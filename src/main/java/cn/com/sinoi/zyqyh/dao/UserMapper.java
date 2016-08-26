package cn.com.sinoi.zyqyh.dao;

import cn.com.sinoi.zyqyh.utils.SearchParams;
import cn.com.sinoi.zyqyh.vo.User;
import cn.com.sinoi.zyqyh.vo.relate.UserDetail;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> findAll();

    List<User> findByCondication(SearchParams params);

    User selectByUserName(String userName);

    List<UserDetail> findAllForPage(Map<String, Object> param);
}
