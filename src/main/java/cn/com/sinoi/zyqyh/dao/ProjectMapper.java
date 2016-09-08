package cn.com.sinoi.zyqyh.dao;

import cn.com.sinoi.zyqyh.vo.Project;
import java.util.List;
import java.util.Map;

public interface ProjectMapper {

    int deleteByPrimaryKey(String projectId);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(String projectId);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKeyWithBLOBs(Project record);

    int updateByPrimaryKey(Project record);

    List<Project> findAllForPage(Map<String, Object> param);

    List<Project> findAll();
}
