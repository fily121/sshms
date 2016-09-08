package cn.com.sinoi.zyqyh.controller.dataController;

import cn.com.sinoi.zyqyh.controller.SystemController;
import cn.com.sinoi.zyqyh.controller.divController.SystemDivController;
import cn.com.sinoi.zyqyh.service.IClglService;
import cn.com.sinoi.zyqyh.utils.PageModel;
import cn.com.sinoi.zyqyh.vo.CllqGl;
import cn.com.sinoi.zyqyh.vo.Clxx;
import cn.com.sinoi.zyqyh.vo.relate.ClglDetail;
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
 * Title: 材料管理管理控制器
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author 杜保军
 *
 * <pre>
 *         修改记录: 版本号 修改人 修改日期 修改内容
 */
@Controller
@RequestMapping("data/cllqgl")
public class CllqglDataController {

    private static final Logger logger = Logger.getLogger(CllqglDataController.class);
    @Autowired
    IClglService clglService;

    /**
     * 删除材料领取记录。
     *
     * @param id 材料领取ID
     * @param model
     * @return 删除成功或者失败
     */
    @RequestMapping("deleteCllqgl.do")
    @ResponseBody
    public boolean deleteCllqgl(String id, Model model) {
        try {
            clglService.deleteByPrimaryKey(id);
            return true;
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(SystemDivController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * 增加修改材料领取记录。
     *
     * @param cllqGl
     * @param response
     * @return
     */
    @RequestMapping(value = "addModifyCllqgl.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> addModifyCllqgl(CllqGl cllqGl, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        Map<String, String> result = new HashMap<>();
        try {
            if (StringUtils.isEmpty(cllqGl.getId())) {
                cllqGl.setId(java.util.UUID.randomUUID().toString());
                clglService.insert(cllqGl);
                result.put("code", "true");
                result.put("message", "保存成功。");
            } else {
                clglService.updateByPrimaryKeySelective(cllqGl);
                result.put("code", "true");
                result.put("message", "修改成功。");
            }
        } catch (Exception ex) {
            result.put("code", "false");
            result.put("message", ex.getMessage());
        }
        return result;
    }

    /**
     * 删除材料。
     *
     * @param id 材料ID
     * @param model
     * @return 删除成功或者失败
     */
    @RequestMapping("deleteClxx.do")
    @ResponseBody
    public boolean deleteClxx(String id, Model model) {
        try {
            clglService.deleteClxxByPrimaryKey(id);
            return true;
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(SystemDivController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * 增加修改材料。
     *
     * @param clxx
     * @param response
     * @return
     */
    @RequestMapping(value = "addModifyClxx.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> addModifyClxx(Clxx clxx, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        Map<String, String> result = new HashMap<>();
        try {
            if (StringUtils.isEmpty(clxx.getId())) {
                clxx.setId(java.util.UUID.randomUUID().toString());
                clglService.insertClxx(clxx);
                result.put("code", "true");
                result.put("message", "保存成功。");
            } else {
                clglService.updateClxxByPrimaryKeySelective(clxx);
                result.put("code", "true");
                result.put("message", "修改成功。");
            }
        } catch (Exception ex) {
            result.put("code", "false");
            result.put("message", ex.getMessage());
        }
        return result;
    }

    /**
     * 根据页码和每页的记录数，取得材料领取记录。
     *
     * @param page 页码
     * @param rows 每页的记录数
     * @return
     */
    @RequestMapping(value = "getClglDetailList.do", method = RequestMethod.POST)
    @ResponseBody
    public PageModel<ClglDetail> getClglDetailList(Integer page, Integer rows) {
        if (page == null || page == 0) {
            page = 1;
        }
        if (rows == null || rows == 0) {
            rows = 10;
        }
        List<ClglDetail> clglDetails = null;
        try {
            clglDetails = clglService.getClglDetailList(page, rows);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(SystemController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (clglDetails != null) {
            PageModel<ClglDetail> result = new PageModel<>(clglDetails, clglDetails.size());
            result.setPage(page);
            return result;
        }
        return null;
    }
}
