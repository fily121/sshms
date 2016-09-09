/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.com.sinoi.zyqyh.service;

import cn.com.sinoi.zyqyh.vo.CllqGl;
import cn.com.sinoi.zyqyh.vo.Clxx;
import cn.com.sinoi.zyqyh.vo.excel.ClglExcel;
import cn.com.sinoi.zyqyh.vo.relate.ClglDetail;
import java.util.List;

/**
 *
 * @author LDNS 杜保軍
 */
public interface IClglService extends IBaseService<CllqGl> {

    int deleteByPrimaryKey(String id);

    int insert(CllqGl record);

    int insertSelective(CllqGl record);

    CllqGl selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CllqGl record);

    int updateByPrimaryKey(CllqGl record);

    List<ClglDetail> getClglDetailList(Integer page, Integer rows, String searchKey, String searchType);

    List<ClglExcel> findAllForExportExcel(String searchKey, String searchType);

    List<Clxx> findAllClxx();

    Clxx selectClxxByPrimaryKey(String id);

    int deleteClxxByPrimaryKey(String id);

    int insertClxx(Clxx clxx);

    int updateClxxByPrimaryKeySelective(Clxx clxx);
}
