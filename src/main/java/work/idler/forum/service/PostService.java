package work.idler.forum.service;

import work.idler.forum.domain.Post;

import java.util.List;

/**
 * 帖子服务层
 *
 * @Auther:https://blog.idler.work
 * @Date:2019/5/10
 * @Description:work.idler.forum.service
 * @version:1.0
 */
public interface PostService {

    /**
     * 查询全部
     *
     * @return list
     */
    List<Post> findAll();

    /**
     * 根据论坛Id 查询全部
     *
     * @return
     */
    List<Post> findAllByForumId(Long forumId);

    /**
     * 根据用户账号 查询全部
     *
     * @param account
     * @return
     */
    List<Post> findAllByAccount(String account);
}
