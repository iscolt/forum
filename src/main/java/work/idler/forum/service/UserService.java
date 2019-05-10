package work.idler.forum.service;

import work.idler.forum.domain.User;

/**
 * 用户服务
 *
 * @Auther:https://blog.idler.work
 * @Date:2019/5/8
 * @Description:work.idler.forum.service
 * @version:1.0
 */
public interface UserService {

    /**
     * 根据账户和密码查询 登录用
     *
     * @param account
     * @param password
     * @return
     */
    User findByUserNameAndUserPass(String account, String password);
}
