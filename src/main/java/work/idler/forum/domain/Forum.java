package work.idler.forum.domain;

import lombok.Data;

/**
 * 论坛
 *
 * @Auther:https://blog.idler.work
 * @Date:2019/5/9
 * @Description:work.idler.forum.domain
 * @version:1.0
 */
@Data
public class Forum {

   private Long forumId;
   private String name;
   private String desc; // 描述
   private String image; // 图片

}
