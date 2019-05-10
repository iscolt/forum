package work.idler.forum.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import work.idler.forum.domain.Forum;

import java.util.List;

/**
 * 论坛数据访问层
 *
 * @Auther:https://blog.idler.work
 * @Date:2019/5/9
 * @Description:work.idler.forum.dao
 * @version:1.0
 */
@Repository
public interface ForumDao {

    /**
     * 查询全部
     *
     * @return list
     */
    @Select("select a.forum_id, a.name, a.desc, a.image from t_forum as a")
    List<Forum> findAll();

    /**
     * 根据论坛Id 查询论坛名
     *
     * @param forumId
     * @return
     */
    @Select("select a.name from t_forum as a " +
            "where a.forum_id=#{forumId}")
    String findForumNameByForumId(Long forumId);
}
