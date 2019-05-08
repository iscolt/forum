package work.idler.forum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import work.idler.forum.dao.UserDao;
import work.idler.forum.domain.User;
import work.idler.forum.service.UserService;

/**
 * @Auther:https://blog.idler.work
 * @Date:2019/5/8
 * @Description:work.idler.forum.service.impl
 * @version:1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    /**
     * 根据账户和密码查询 登录用
     *
     * @param account
     * @param password
     * @return
     */
    @Override
    public User findByUserNameAndUserPass(String account, String password) {
        return userDao.findByUserNameAndUserPass(account, DigestUtils.md5DigestAsHex(password.getBytes()));
    }
}
