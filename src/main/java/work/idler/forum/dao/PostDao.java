package work.idler.forum.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import work.idler.forum.domain.Post;

import java.util.List;

/**
 * 帖子数据访问层
 *
 * @Auther:https://blog.idler.work
 * @Date:2019/5/10
 * @Description:work.idler.forum.dao
 * @version:1.0
 */
@Repository
public interface PostDao {

    /**
     * 查询全部
     *
     * @return list
     */
    @Select("select a.post_id, a.forum_id, a.title, a.content, a.thumbnail, a.post_time, account from t_post as a")
    List<Post> findAll();

    /**
     * 根据论坛Id 查询全部
     *
     * @return
     */
    @Select("select a.post_id, a.forum_id, a.title, a.content, a.thumbnail, a.post_time, a.account " +
            "from t_post as a " +
            "where a.forum_id=#{forumId}")
    List<Post> findAllByForumId(Long forumId);

    /**
     * 根据用户账号 查询全部
     *
     * @param account
     * @return
     */
    @Select("select a.post_id, a.forum_id, a.title, a.content, a.thumbnail, a.post_time, a.account " +
            "from t_post as a" +
            "where a.account=#{account}")
    List<Post> findAllByAccount(String account);
}
