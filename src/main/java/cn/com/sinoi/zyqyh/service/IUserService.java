package cn.com.sinoi.zyqyh.service;

import cn.com.sinoi.zyqyh.utils.Pagination;
import cn.com.sinoi.zyqyh.utils.SearchParams;
import cn.com.sinoi.zyqyh.vo.User;
import cn.com.sinoi.zyqyh.vo.relate.UserDetail;
import java.util.List;
import java.util.Map;

public interface IUserService extends IBaseService<User> {

    int save(User record) throws Exception;

    int delete(String id) throws Exception;

    int update(User record) throws Exception;

    User get(User record) throws Exception;

    User selectById(String id);

    User selectByUserName(String userName) throws Exception;

    List<User> findAll() throws Exception;

    Pagination<User> findByCondication(SearchParams params) throws Exception;

    List<UserDetail> findAllForPage(int page, int rows, String searchKey);

    User selectByWechatNo(String 微信号);

    User selectByOpenId(String fromUserName);

    List<User> findUsersBySgdId(String id);

    Map<Integer, Integer> selectNumOfType(String type, String id);
}
