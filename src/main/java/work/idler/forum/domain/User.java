package work.idler.forum.domain;

import lombok.Data;

/**
 * 用户
 *
 * @Auther:https://blog.idler.work
 * @Date:2019/5/8
 * @Description:work.idler.forum.domain
 * @version:1.0
 */
@Data
public class User {

    private Long id;
    private String account; // 账号
    private String password; // 密码
    private String nickname; // 昵称
    private String avatar; // 头像
    private Integer points; // 分数

}
