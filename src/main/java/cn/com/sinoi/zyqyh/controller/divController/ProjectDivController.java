package cn.com.sinoi.zyqyh.controller.divController;

import cn.com.sinoi.zyqyh.service.IAttachmentService;
import cn.com.sinoi.zyqyh.service.IProjectService;
import cn.com.sinoi.zyqyh.vo.Attachment;
import cn.com.sinoi.zyqyh.vo.Project;
import java.io.File;
import java.util.logging.Level;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("div/projectManage")
public class ProjectDivController {

    private static final Logger logger = Logger.getLogger(ProjectDivController.class);
    @Autowired
    private IProjectService projectService;
    @Autowired
    private IAttachmentService attachmentService;

    @Value("#{readProperties['upload.file.path']}")
    private String path;

    @RequestMapping("addModifyProject.do")
    public String addModifyProject(String id, Model model) {
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(id)) {
            try {
                Project project = projectService.selectByPrimaryKey(id);
                model.addAttribute("project", project);
                String attachmentId = project.getAttachmentId();
                if (StringUtils.isNotEmpty(attachmentId)) {
                    Attachment atta = attachmentService.findbyId(attachmentId);
                    File file = new File(path + atta.getUri());
                    if (file.exists()) {
                        model.addAttribute("files", file.listFiles());
                    }
                }
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(SystemDivController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "projectManage/addModifyProject";
    }
}
