package cn.com.sinoi.zyqyh.controller.dataController;

import cn.com.sinoi.zyqyh.controller.SystemController;
import cn.com.sinoi.zyqyh.controller.divController.SystemDivController;
import cn.com.sinoi.zyqyh.service.ISgdxxService;
import cn.com.sinoi.zyqyh.utils.PageModel;
import cn.com.sinoi.zyqyh.vo.Sgdxx;
import cn.com.sinoi.zyqyh.vo.relate.SgdxxDetail;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
