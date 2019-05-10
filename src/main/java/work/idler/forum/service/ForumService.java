package work.idler.forum.service;

import work.idler.forum.domain.Forum;

import java.util.List;

/**
 * 论坛服务
 *
 * @Auther:https://blog.idler.work
 * @Date:2019/5/9
 * @Description:work.idler.forum.service
 * @version:1.0
 */
public interface ForumService {

    /**
     * 查询全部
     *
     * @return list
     */
    List<Forum> findAll();

    /**
     * 根据论坛Id 查询论坛名
     *
     * @param forumId
     * @return
     */
    String findForumNameByForumId(Long forumId);
}
