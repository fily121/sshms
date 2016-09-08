package cn.com.sinoi.zyqyh.controller.dataController;

import cn.com.sinoi.zyqyh.controller.SystemController;
import cn.com.sinoi.zyqyh.controller.divController.SystemDivController;
import cn.com.sinoi.zyqyh.definition.FilePathEnum;
import cn.com.sinoi.zyqyh.service.IAttachmentService;
import cn.com.sinoi.zyqyh.service.IClglService;
import cn.com.sinoi.zyqyh.service.IOrderService;
import cn.com.sinoi.zyqyh.service.ISgdxxService;
import cn.com.sinoi.zyqyh.utils.PageModel;
import cn.com.sinoi.zyqyh.utils.UrlDownloadFile;
import cn.com.sinoi.zyqyh.vo.Attachment;
import cn.com.sinoi.zyqyh.vo.Clxx;
import cn.com.sinoi.zyqyh.vo.Order;
import cn.com.sinoi.zyqyh.vo.Sgdxx;
import cn.com.sinoi.zyqyh.vo.relate.OrderDetail;
import cn.com.sinoi.zyqyh.vo.relate.SgdxxDetail;
import cn.com.sinoi.zyqyh.weixin.MessageUtil;
import cn.com.sinoi.zyqyh.weixin.WeixinUtil;
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
import static cn.com.sinoi.zyqyh.utils.DateUtil.FORMATTER_YMDHMS;
import static cn.com.sinoi.zyqyh.utils.DateUtil.FORMATTER_YMD;

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
@RequestMapping("data/baseManage")
public class BaseDataController {

    private static final Logger logger = Logger.getLogger(BaseDataController.class);

    @Autowired
    ISgdxxService sgdxxService;

    @Autowired
    IOrderService orderService;

    @Autowired
    IAttachmentService attachmentService;

    @Autowired
    IClglService clglService;

    @Value("#{readProperties['wechat.corpId']}")
    private String corpId;
    @Value("#{readProperties['wechat.secret']}")
    private String secret;

    @Value("#{readProperties['upload.file.path']}")
    private String path;

    @RequestMapping("getSgdList.do")
    @ResponseBody
    public PageModel<SgdxxDetail> getSgdList(Integer page, Integer rows) {
        if (page == null || page == 0) {
            page = 1;
        }
        if (rows == null || rows == 0) {
            rows = 10;
        }
        List<SgdxxDetail> sgdList = null;
        try {
            sgdList = sgdxxService.findAllForPage(page, rows);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(SystemController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (sgdList != null) {
            PageModel<SgdxxDetail> result = new PageModel<>(sgdList, sgdList.size());
            result.setPage(page);
            return result;
        }
        return null;
    }

    /**
     * 增加修改施工队伍
     *
     * @param sgdxx
     * @param response
     * @return
     */
    @RequestMapping(value = "addModifySgdxx.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> addModifySgdxx(Sgdxx sgdxx, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        Map<String, String> result = new HashMap<>();
        try {
            if (StringUtils.isEmpty(sgdxx.getId())) {
                Sgdxx existSgdxx = sgdxxService.selectBySgdmc(sgdxx.getSgdmc());
                if (existSgdxx != null) {
                    result.put("code", "false");
                    result.put("message", "施工队名称已存在。");
                    return result;
                }
                SgdxxDetail existSgdxxDetail = sgdxxService.selectByCph(sgdxx.getCph());
                if (existSgdxxDetail != null) {
                    result.put("code", "false");
                    result.put("message", "施工队车牌号已存在。");
                    return result;
                }

                sgdxx.setId(java.util.UUID.randomUUID().toString());
                sgdxxService.insert(sgdxx);
                result.put("code", "true");
                result.put("message", "保存成功。");
            } else {
                sgdxxService.updateByPrimaryKeySelective(sgdxx);
                result.put("code", "true");
                result.put("message", "修改成功。");
            }
        } catch (Exception ex) {
            result.put("code", "false");
            result.put("message", ex.getMessage());
        }
        return result;
    }

    @RequestMapping("deleteSgdw.do")
    @ResponseBody
    public boolean deleteSgdw(String id, Model model) {
        try {
            sgdxxService.deleteByPrimaryKey(id);
            return true;
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(SystemDivController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @RequestMapping(value = "getAllSgd.do", method = RequestMethod.POST)
    @ResponseBody
    public List<Sgdxx> getAllSgd() {
        List<Sgdxx> result = Collections.EMPTY_LIST;
        try {
            result = sgdxxService.findAll();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(SystemDataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    /**
     * 获取所有材料信息。
     *
     * @return
     */
    @RequestMapping(value = "getAllClxx.do", method = RequestMethod.POST)
    @ResponseBody
    public List<Clxx> getAllClxx() {
        List<Clxx> result = Collections.EMPTY_LIST;
        try {
            result = clglService.findAllClxx();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(SystemDataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @RequestMapping(value = "addModifyOrder.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> addModifyOrder(Order order, @RequestParam(value = "uploadFile", required = false) MultipartFile[] uploadFile, HttpServletResponse response) {
        Map<String, String> result = new HashMap<>();
        if (order != null) {
            List<String> openIds = sgdxxService.findOpenIdByGcdId(order.getSgdid());
            String access_token = WeixinUtil.getAccessToken(corpId, secret).getToken();
            String dateTime = FORMATTER_YMDHMS.format(new Date());
            response.setContentType("text/html;charset=UTF-8");
            String msg = "订单创建成功。";
            if (StringUtils.isNotEmpty(order.getOrderId())) {
                Attachment atta = attachmentService.findbyId(order.getAttachmentId());
                try {
                    for (MultipartFile file : uploadFile) {
                        if (file.getSize() != 0) {
                            UrlDownloadFile.copyFileToPath(file.getInputStream(), path + atta.getUri(), file.getOriginalFilename());
                        }
                    }
                } catch (IOException ex) {
                    java.util.logging.Logger.getLogger(BaseDataController.class.getName()).log(Level.SEVERE, null, ex);
                }
                OrderDetail oldOrderDetail = orderService.selectByOrderId(order.getOrderId());
                String oldOrderName = oldOrderDetail.getOrder().getOrderName();
                orderService.updateByPrimaryKeySelective(order);
                msg = "订单修改成功。";
                for (String openId : openIds) {
                    String jsonString = MessageUtil.getOrderMessage(openId, "订单有变更，原订单名：" + oldOrderName, dateTime, order.getOrderName(), order.getOrderId(), "您的订单有变更，请登录系统查看。", "");
                    WeixinUtil.PostMessage(access_token, "POST", MessageUtil.MB_SEND_URL, jsonString);
                }
            } else {
                order.setOrderId(java.util.UUID.randomUUID().toString());
                Date date = new Date();
                String uri = FilePathEnum.订单管理.getPath() + FORMATTER_YMD.format(date) + "/" + order.getOrderId();
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
                order.setAttachmentId(atta.getId());
                order.setCreateDate(date);
                orderService.insert(order);
                for (String openId : openIds) {
                    String jsonString = MessageUtil.getOrderMessage(openId, "新的订单", dateTime, order.getOrderName(), order.getOrderId(), "您有新的订单，请登录系统查看。", "");
                    WeixinUtil.PostMessage(access_token, "POST", MessageUtil.MB_SEND_URL, jsonString);
                }
            }
            result.put("code", "true");
            result.put("message", msg);
            return result;
        }
        result.put("code", "false");
        result.put("message", "失败");
        return result;
    }

    @RequestMapping(value = "deleteFile.do", method = RequestMethod.POST)
    @ResponseBody
    public void deleteFile(String attachmentId, String fileName, String sgdId, String orderName, String orderId) {
        if (StringUtils.isNotEmpty(attachmentId)) {
            Attachment att = attachmentService.findbyId(attachmentId);
            if (att != null) {
                File file = new File(path + att.getUri() + "/" + (StringUtils.isNotEmpty(fileName) ? fileName : att.getFileName()));
                file.delete();
                List<String> openIds = sgdxxService.findOpenIdByGcdId(sgdId);
                String access_token = WeixinUtil.getAccessToken(corpId, secret).getToken();
                String dateTime = FORMATTER_YMDHMS.format(new Date());
                for (String openId : openIds) {
                    String jsonString = MessageUtil.getOrderMessage(openId, 订单变更通知, dateTime, orderName, orderId, 订单有变化文件删除, "");
                    WeixinUtil.PostMessage(access_token, "POST", MessageUtil.MB_SEND_URL, jsonString);
                }
            }
        }
    }
    private static final String 订单有变化文件删除 = "订单有变化（文件删除）， 请登录后台查看。";
    private static final String 订单变更通知 = "订单变更通知";

    @RequestMapping(value = "getOrderList.do", method = RequestMethod.POST)
    @ResponseBody
    public List<OrderDetail> getOrderList(Integer page, Integer rows, String searchKey) {
        List<OrderDetail> result = Collections.EMPTY_LIST;
        try {
            result = orderService.findAllForPage(page, rows, searchKey);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(SystemDataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
