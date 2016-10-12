package cn.com.sinoi.zyqyh.controller.mobile;

import cn.com.sinoi.zyqyh.controller.dataController.BaseDataController;
import cn.com.sinoi.zyqyh.controller.dataController.SystemDataController;
import cn.com.sinoi.zyqyh.definition.FilePathEnum;
import cn.com.sinoi.zyqyh.definition.RoleEnum;
import cn.com.sinoi.zyqyh.service.IAttachmentService;
import cn.com.sinoi.zyqyh.service.IGzzdService;
import cn.com.sinoi.zyqyh.service.IUserService;
import cn.com.sinoi.zyqyh.service.IWechatService;
import static cn.com.sinoi.zyqyh.utils.DateUtil.FORMATTER_YMD;
import cn.com.sinoi.zyqyh.utils.ShiroUtils;
import cn.com.sinoi.zyqyh.utils.UrlDownloadFile;
import cn.com.sinoi.zyqyh.vo.Attachment;
import cn.com.sinoi.zyqyh.vo.Gzzd;
import cn.com.sinoi.zyqyh.vo.User;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
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
 * Title: 规章制度管理控制器
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
@RequestMapping("mobile")
public class MobileGzzdController {

    private static final Logger logger = Logger.getLogger(MobileGzzdController.class);
    @Autowired
    private IWechatService wechatService;

    @Autowired
    IGzzdService gzzdService;
    @Autowired
    IUserService userService;

    @Autowired
    IAttachmentService attachmentService;
    @Value("#{readProperties['upload.file.path']}")
    private String path;

    @RequestMapping("gzzdManage.do")
    public String gzzdManage(String code, Model model) {
//        if (StringUtils.isEmpty(code)) {
//            model.addAttribute("errorMessage", "请从微信菜单打开");
//            return "mobile/noauthorized";
//        }
        String result = wechatService.loginWithCode(code);
        if (StringUtils.isNotEmpty(result)) {
            model.addAttribute("errorMessage", result);
            return "mobile/noauthorized";
        }
        return "mobile/gzzdManage";
    }

    @RequestMapping(value = "addModifyGzzd.do", method = RequestMethod.GET)
    public String addModifyGzzd(Model model, String id) throws Exception {
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(id)) {
            try {
                Gzzd gzzd = gzzdService.selectByPrimaryKey(id);
                model.addAttribute("gzzd", gzzd);
                String attachmentId = gzzd.getAttachmentid();
                if (StringUtils.isNotEmpty(attachmentId)) {
                    Attachment atta = attachmentService.findbyId(attachmentId);
                    File file = new File(path + atta.getUri());
                    if (file.exists()) {
                        model.addAttribute("files", file.listFiles());
                    }
                }
            } catch (Exception ex) {
                logger.error(ex.getMessage());
            }
        }
        return "mobile/addModifyGzzd";
    }

    @RequestMapping(value = "addModifyGzzd.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> saveGzzd(Model model, Gzzd gzzd, @RequestParam(value = "uploadFile", required = false) MultipartFile[] uploadFile, HttpServletResponse response) throws Exception {
        Map<String, String> map = new HashMap<>();
        response.setContentType("text/html;charset=UTF-8");
        String msg = "修改成功。";
        Date date = new Date();
        if (StringUtils.isEmpty(gzzd.getId())) {
            msg = "发布成功。";
            User user = ShiroUtils.getUserBySubject(userService);
            gzzd.setId(UUID.randomUUID().toString());
            gzzd.setLastmodifytime(date);
            gzzd.setLastmodifyuserid(user.getUserId());
        }
        Attachment atta = attachmentService.findbyId(gzzd.getAttachmentid());
        if (atta == null) {
            String uri = FilePathEnum.规章制度.getPath() + FORMATTER_YMD.format(date) + "/" + gzzd.getId();
            atta = new Attachment();
            atta.setId(java.util.UUID.randomUUID().toString());
            atta.setUri(uri);
            attachmentService.save(atta);
        }
        try {
            for (MultipartFile file : uploadFile) {
                if (file.getSize() != 0) {
                    UrlDownloadFile.copyFileToPath(file.getInputStream(), path + atta.getUri(), file.getOriginalFilename());
                }
            }
        } catch (IOException ex) {
            map.put("code", "false");
            map.put("message", "发布失败");
            java.util.logging.Logger.getLogger(BaseDataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        map.put("code", "true");
        map.put("message", msg);
        map.put("id", gzzd.getId());
        return map;
    }

    @RequestMapping(value = "viewGzzd.do", method = RequestMethod.GET)
    public String viewOrder(String keywords, Model model) throws Exception {
        return "mobile/viewGzzd";
    }

    @RequestMapping(value = "findGzzd.do", method = RequestMethod.GET)
    public String findGzzd(String keywords, Model model) throws Exception {
        User user = ShiroUtils.getUserBySubject(userService);
        String userId = null;
        if (RoleEnum.fromCode(user.getRoleId()) != RoleEnum.管理员用户) {
            userId = user.getOrgId();
        }
        List<Gzzd> result = Collections.EMPTY_LIST;
        try {
            result = gzzdService.findAllForLimit(keywords, userId);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(SystemDataController.class.getName()).log(Level.SEVERE, null, ex);
            model.addAttribute("error", "查询失败");
        }
        model.addAttribute("gzzdList", result);
        return "mobile/gzzdList";
    }

    @RequestMapping("gzzdDetail.do")
    public String gzzdDetail(String id, Model model) {
        if (StringUtils.isNotEmpty(id)) {
            Gzzd gzzd = gzzdService.selectByPrimaryKey(id);
            try {
                User user = userService.selectById(gzzd.getLastmodifyuserid());
                if (user != null) {
                    model.addAttribute("addUser", user.getName());
                }
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(MobileGzzdController.class.getName()).log(Level.SEVERE, null, ex);
            }
            String attachmentId = gzzd.getAttachmentid();
            if (StringUtils.isNotEmpty(attachmentId)) {
                Attachment atta = attachmentService.findbyId(attachmentId);
                File file = new File(path + atta.getUri());
                if (file.exists()) {
                    model.addAttribute("files", file.listFiles());
                }
            }
            model.addAttribute("gzzd", gzzd);
        }
        return "mobile/gzzdDetail";
    }
}
