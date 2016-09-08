package cn.com.sinoi.zyqyh.service.impl;

import cn.com.sinoi.zyqyh.dao.ProjectMapper;
import cn.com.sinoi.zyqyh.service.IProjectService;
import cn.com.sinoi.zyqyh.utils.Pagination;
import cn.com.sinoi.zyqyh.utils.SearchParams;
import cn.com.sinoi.zyqyh.vo.Project;
import com.alibaba.druid.util.StringUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("projectService")
public class ProjectServiceImpl implements IProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public Pagination<Project> findPageByCondition(SearchParams params) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Project> findByCondition(SearchParams params) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Project> findAll() throws Exception {
        return projectMapper.findAll();
    }

    @Override
    public List<Project> findAllForPage(Integer page, Integer rows, String searchKey) {
        Map<String, Object> param = new HashMap<>();
        param.put("limit1", (page - 1) * rows);
        param.put("limit2", rows);
        param.put("searchKey", StringUtils.isEmpty(searchKey) ? null : searchKey);
        return projectMapper.findAllForPage(param);
    }

    @Override
    public void updateByPrimaryKeySelective(Project project) {
        projectMapper.updateByPrimaryKeySelective(project);
    }

    @Override
    public void insert(Project project) {
        projectMapper.insert(project);
    }

    @Override
    public void deleteByPrimaryKey(String id) {
        projectMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Project selectByPrimaryKey(String id) {
        return projectMapper.selectByPrimaryKey(id);
    }

}
