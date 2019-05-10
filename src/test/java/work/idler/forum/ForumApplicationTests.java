package work.idler.forum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;
import work.idler.forum.dao.ForumDao;
import work.idler.forum.dao.UserDao;
import work.idler.forum.domain.Forum;
import work.idler.forum.domain.User;
import work.idler.forum.service.ForumService;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("work.idler.forum.dao")
public class ForumApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private UserDao userDao;

    @Autowired
    private ForumDao forumDao;

    @Autowired
    private ForumService forumService;

    @Test
    public void userTest() {
        // 插入第一个用户, 用一次
//        User user = new User();
//        user.setAccount("iscolt@qq.com");
//        user.setPassword(DigestUtils.md5DigestAsHex("5211".getBytes()));
//        user.setNickname("iscolt");
//        user.setAvatar("https://blog.idler.work/images/logo.png");
//        user.setPoints(1000);
//        userDao.insertUser(user);
    }

    @Test
    public void forumTest() {
        List<Forum> forums = new ArrayList<>();
        forums = forumService.findAll();
        System.out.println(forums.size());
    }
}
