package work.idler.forum.domain;

import lombok.Data;

/**
 * 帖子
 *
 * @Auther:https://blog.idler.work
 * @Date:2019/5/10
 * @Description:work.idler.forum.domain
 * @version:1.0
 */
@Data
public class Post {

    private Long postId;
    private Long ForumId; // 所属论坛ID
    private String title;
    private String content;
    private String thumbnail; // 缩略图
    private String postTime; // 时间
    private String account; // 谁发的

}
