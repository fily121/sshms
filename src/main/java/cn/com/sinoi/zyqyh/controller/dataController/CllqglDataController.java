package cn.com.sinoi.zyqyh.controller.dataController;

import cn.com.sinoi.zyqyh.controller.SystemController;
import cn.com.sinoi.zyqyh.controller.divController.SystemDivController;
import cn.com.sinoi.zyqyh.service.IClglService;
import cn.com.sinoi.zyqyh.utils.FileUtil;
import cn.com.sinoi.zyqyh.utils.PageModel;
import cn.com.sinoi.zyqyh.utils.UrlDownloadFile;
import cn.com.sinoi.zyqyh.vo.CllqGl;
import cn.com.sinoi.zyqyh.vo.Clxx;
import cn.com.sinoi.zyqyh.vo.excel.ClglExcel;
import cn.com.sinoi.zyqyh.vo.relate.ClglDetail;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
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

    @Value("#{readProperties['upload.file.path']}")
    private String path;

    @Value("#{readProperties['upload.tempfiles.path']}")
    private String temp;

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
     * @param searchKey 检索关键字
     * @param searchType 检索类型
     * @return
     */
    @RequestMapping(value = "getClglDetailList.do", method = RequestMethod.POST)
    @ResponseBody
    public PageModel<ClglDetail> getClglDetailList(Integer page, Integer rows, String searchKey, String searchType) {
        if (page == null || page == 0) {
            page = 1;
        }
        if (rows == null || rows == 0) {
            rows = 10;
        }
        if ("".equals(searchKey)) {
            searchKey = null;
        }
        if (searchType == null || "".equals(searchType)) {
            searchType = "0";
        }
        List<ClglDetail> clglDetails = null;
        try {
            clglDetails = clglService.getClglDetailList(page, rows, searchKey, searchType);
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

    /**
     * 将领取记录导出到ｅｘｃｅｌ中。
     *
     * @param searchKey
     * @param searchType
     * @param response
     * @return
     */
    @RequestMapping("exportCllqgl.do")
    @ResponseBody
    public String exportCllqgl(String searchKey, String searchType, HttpServletResponse response) {
        String fname = "材料领取记录";
        try {
            fname = java.net.URLEncoder.encode(fname, "UTF-8");
            File filePath = new File(path + temp);
            String realFileName = path + temp + new String(fname.getBytes("UTF-8"), "GBK") + ".xls";
            File file = new File(realFileName);
            file.deleteOnExit();
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            List<ClglExcel> excels = clglService.findAllForExportExcel(searchKey, searchType);
            OutputStream os = new FileOutputStream(file);//取得输出流
            //下面是对中文文件名的处理
//            response.setCharacterEncoding("UTF-8");//设置相应内容的编码格式
//            response.setHeader("Content-Disposition", "attachment;filename=" + new String(fname.getBytes("UTF-8"), "GBK") + ".xls");
//            response.setContentType("application/msexcel");//定义输出类型
            excels.add(0, createClglExcelHeader());
            FileUtil.createExcel(os, excels, ClglExcel.class);
            UrlDownloadFile.downLoadFileLocal(realFileName, response, false);
            return null;
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(CllqglDataController.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
    }

    private ClglExcel createClglExcelHeader() {
        ClglExcel excel = new ClglExcel();
        excel.setClmc("材料名称");
        excel.setClshengyu("剩余数量");
        excel.setDetail("材料详情");
        excel.setLqsl("领取数量");
        excel.setLqtime("领取日期");
        excel.setSgdmc("领取队伍名称");
        excel.setSysl("已使用数量");
        return excel;
    }
}
