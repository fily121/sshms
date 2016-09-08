package cn.com.sinoi.zyqyh.controller.dataController;

import cn.com.sinoi.zyqyh.controller.SystemController;
import cn.com.sinoi.zyqyh.controller.divController.SystemDivController;
import cn.com.sinoi.zyqyh.definition.FilePathEnum;
import cn.com.sinoi.zyqyh.service.IAttachmentService;
import cn.com.sinoi.zyqyh.service.IProjectService;
import static cn.com.sinoi.zyqyh.utils.DateUtil.FORMATTER_YMD;
import cn.com.sinoi.zyqyh.utils.PageModel;
import cn.com.sinoi.zyqyh.utils.UrlDownloadFile;
import cn.com.sinoi.zyqyh.vo.Attachment;
import cn.com.sinoi.zyqyh.vo.Project;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * Title: 基础管理管理控制器
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author 强成西
 *
 * <pre>
 *         修改记录: 版本号 修改人 修改日期 修改内容
 */
@Controller
@RequestMapping("data/projectManage")
public class ProjectDataController {

    private static final Logger logger = Logger.getLogger(ProjectDataController.class);

    @Value("#{readProperties['upload.file.path']}")
    private String path;

    @Autowired
    private IProjectService projectService;

    @Autowired
    private IAttachmentService attachmentService;

    @RequestMapping(value = "getProjectList.do", method = RequestMethod.POST)
    @ResponseBody
    public PageModel<Project> getProjectList(Integer page, Integer rows, String searchKey, Boolean all) {
        if (page == null || page == 0) {
            page = 1;
        }
        if (rows == null || rows == 0) {
            rows = 10;
        }
        List<Project> projectList = null;
        try {
            if (all != null && all) {
                projectList = projectService.findAll();
            } else {
                projectList = projectService.findAllForPage(page, rows, searchKey);
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(SystemController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (projectList != null) {
            PageModel<Project> result = new PageModel<>(projectList, projectList.size());
            result.setPage(page);
            return result;
        }
        return null;
    }

    /**
     * 增加修改施工队伍
     *
     * @param project
     * @param response
     * @return
     */
    @RequestMapping(value = "addModifyProject.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> addModifyProject(Project project, HttpServletResponse response, @RequestParam(value = "uploadFile", required = false) MultipartFile[] uploadFile) {
        response.setContentType("text/html;charset=UTF-8");
        Map<String, String> result = new HashMap<>();
        try {
            if (StringUtils.isEmpty(project.getProjectId())) {
                project.setProjectId(java.util.UUID.randomUUID().toString());
                project.setCreateTime(new Date());
                Date date = new Date();
                String uri = FilePathEnum.工程管理.getPath() + FORMATTER_YMD.format(date) + "/" + project.getProjectId();
                try {
                    for (MultipartFile file : uploadFile) {
                        if (file.getSize() != 0) {
                            UrlDownloadFile.copyFileToPath(file.getInputStream(), path + uri, file.getOriginalFilename());
                        }
                    }
                } catch (IOException ex) {
                    java.util.logging.Logger.getLogger(BaseDataController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Attachment atta = new Attachment();
                atta.setId(java.util.UUID.randomUUID().toString());
                atta.setUri(uri);
                attachmentService.save(atta);
                project.setAttachmentId(atta.getId());
                projectService.insert(project);
                result.put("code", "true");
                result.put("message", "保存成功。");
            } else {
                Attachment atta = attachmentService.findbyId(project.getAttachmentId());
                try {
                    for (MultipartFile file : uploadFile) {
                        if (file.getSize() != 0) {
                            UrlDownloadFile.copyFileToPath(file.getInputStream(), path + atta.getUri(), file.getOriginalFilename());
                        }
                    }
                } catch (IOException ex) {
                    java.util.logging.Logger.getLogger(BaseDataController.class.getName()).log(Level.SEVERE, null, ex);
                }
                projectService.updateByPrimaryKeySelective(project);
                result.put("code", "true");
                result.put("message", "修改成功。");
            }
        } catch (Exception ex) {
            result.put("code", "false");
            result.put("message", ex.getMessage());
        }
        return result;
    }

    @RequestMapping("deleteProject.do")
    @ResponseBody
    public boolean deleteProject(String id, Model model) {
        try {
            Project project = projectService.selectByPrimaryKey(id);
            String attachmentId = project.getAttachmentId();
            if (org.apache.commons.lang3.StringUtils.isNotEmpty(attachmentId)) {
                Attachment atta = attachmentService.findbyId(attachmentId);
                File file = new File(path + atta.getUri());
                if (file.exists()) {
                    file.delete();
                }
            }
            projectService.deleteByPrimaryKey(id);
            return true;
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(SystemDivController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @RequestMapping(value = "getAllSgd.do", method = RequestMethod.POST)
    @ResponseBody
    public List<Project> getAllProject() {
        List<Project> result = Collections.EMPTY_LIST;
        try {
            result = projectService.findAll();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(SystemDataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @RequestMapping(value = "deleteFile.do", method = RequestMethod.POST)
    @ResponseBody
    public void deleteFile(String attachmentId, String fileName) {
        if (StringUtils.isNotEmpty(attachmentId)) {
            Attachment att = attachmentService.findbyId(attachmentId);
            if (att != null && StringUtils.isNotEmpty(fileName)) {
                File file = new File(path + att.getUri() + "/" + (StringUtils.isNotEmpty(fileName) ? fileName : att.getFileName()));
                file.delete();
            }
        }
    }
}
