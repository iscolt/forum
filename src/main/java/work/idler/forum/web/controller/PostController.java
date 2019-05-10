package work.idler.forum.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import work.idler.forum.commons.constant.ConstantUtils;
import work.idler.forum.domain.User;
import work.idler.forum.service.ForumService;
import work.idler.forum.service.PostService;

import javax.servlet.http.HttpServletRequest;

/**
 * 帖子控制层
 *
 * @Auther:https://blog.idler.work
 * @Date:2019/5/9
 * @Description:work.idler.forum.web.controller
 * @version:1.0
 */
@Controller
@RequestMapping(value = "posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private ForumService forumService;

    /**
     * 根据forumId 查询帖子
     *
     * @param httpServletRequest
     * @param model
     * @param forumId
     * @return
     */
    @GetMapping("/{forumId}")
    public String post(HttpServletRequest httpServletRequest, Model model, @PathVariable(value = "forumId") Long forumId){
        // 将 uri 放入会话
        httpServletRequest.getSession().setAttribute(ConstantUtils.SESSION_ACTIVEURI, "posts");

        // 获取 名为 ConstantUtils.SESSION_USER 的 session 值
        User user = (User) httpServletRequest.getSession().getAttribute(ConstantUtils.SESSION_USER);
        // 如果 session 为空
        if(user == null) {
            // 没有 session? 登录去
            model.addAttribute(ConstantUtils.SESSION_LOGIN_ERROR, "你还没有登录! ");
            return "login";
        }

        // 如果 session user 不为空
        else {
            // 登录了? 放你去
            // 将根据论坛id查询的帖子放入 model
            model.addAttribute("posts", postService.findAllByForumId(forumId));
            // 将根据论坛id查询的论坛名放入 model
            model.addAttribute("forumName", forumService.findForumNameByForumId(forumId));
            return "post";
        }
    }
}
