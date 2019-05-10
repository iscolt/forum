package work.idler.forum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.idler.forum.dao.ForumDao;
import work.idler.forum.domain.Forum;
import work.idler.forum.service.ForumService;

import java.util.List;

/**
 * 论坛服务实现
 *
 * @Auther:https://blog.idler.work
 * @Date:2019/5/9
 * @Description:work.idler.forum.service.impl
 * @version:1.0
 */
@Service
public class ForumServiceImpl implements ForumService {

    @Autowired
    private ForumDao forumDao;

    /**
     * 查询全部
     *
     * @return list
     */
    @Override
    public List<Forum> findAll() {
        return forumDao.findAll();
    }

    /**
     * 根据论坛Id 查询论坛名
     *
     * @param forumId
     * @return
     */
    @Override
    public String findForumNameByForumId(Long forumId) {
        return forumDao.findForumNameByForumId(forumId);
    }
}
