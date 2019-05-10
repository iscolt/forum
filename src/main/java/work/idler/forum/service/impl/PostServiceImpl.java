package work.idler.forum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.idler.forum.dao.PostDao;
import work.idler.forum.domain.Post;
import work.idler.forum.service.PostService;

import java.util.List;

/**
 * 帖子服务层实现
 *
 * @Auther:https://blog.idler.work
 * @Date:2019/5/10
 * @Description:work.idler.forum.service.impl
 * @version:1.0
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    /**
     * 查询全部
     *
     * @return
     */
    @Override
    public List<Post> findAll() {
        return postDao.findAll();
    }

    /**
     * 根据论坛Id 查询全部
     *
     * @param forumId
     * @return
     */
    @Override
    public List<Post> findAllByForumId(Long forumId) {
        return postDao.findAllByForumId(forumId);
    }

    /**
     * 根据用户账号 查询全部
     *
     * @param account
     * @return
     */
    @Override
    public List<Post> findAllByAccount(String account) {
        return postDao.findAllByAccount(account);
    }
}
