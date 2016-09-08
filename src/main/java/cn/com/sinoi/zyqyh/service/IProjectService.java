package cn.com.sinoi.zyqyh.service;

import cn.com.sinoi.zyqyh.vo.Project;
import java.util.List;

public interface IProjectService extends IBaseService<Project> {

    List<Project> findAllForPage(Integer page, Integer rows, String searchKey);

    void updateByPrimaryKeySelective(Project sgdxx);

    void insert(Project sgdxx);

    void deleteByPrimaryKey(String id);

    Project selectByPrimaryKey(String id);

}
