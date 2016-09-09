package cn.com.sinoi.zyqyh.dao;

import cn.com.sinoi.zyqyh.vo.CllqGl;
import cn.com.sinoi.zyqyh.vo.excel.ClglExcel;
import cn.com.sinoi.zyqyh.vo.relate.ClglDetail;
import java.util.List;
import java.util.Map;

public interface CllqGlMapper {

    List<CllqGl> findAll();

    int deleteByPrimaryKey(String id);

    int insert(CllqGl record);

    int insertSelective(CllqGl record);

    CllqGl selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CllqGl record);

    int updateByPrimaryKey(CllqGl record);

    List<ClglDetail> findAllForPage(Map<String, Object> param);

    List<ClglExcel> findAllForExportExcel(Map<String, String> param);
}
