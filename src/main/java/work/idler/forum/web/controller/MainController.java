package work.idler.forum.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import work.idler.forum.commons.constant.ConstantUtils;
import work.idler.forum.domain.User;
import work.idler.forum.service.ForumService;

import javax.servlet.http.HttpServletRequest;

/**
 * 主页控制器
 *
 * @Auther:https://blog.idler.work
 * @Date:2019/5/8
 * @Description:work.idler.forum.web.controller
 * @version:1.0
 */
@Controller
public class MainController {

    @Autowired
    private ForumService forumService;

    @RequestMapping(value = "main", method = RequestMethod.GET)
    public String main(HttpServletRequest httpServletRequest, Model model){
        // 将 uri 放入会话
        httpServletRequest.getSession().setAttribute(ConstantUtils.SESSION_ACTIVEURI, "main");

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
            // 把 论坛放进去
            model.addAttribute("forums", forumService.findAll());
            // 登录了? 给你去主页
            return "main";
        }
    }

    @RequestMapping(value = "space", method = RequestMethod.GET)
    public String space(HttpServletRequest httpServletRequest, Model model){
        // 将 uri 放入会话
        httpServletRequest.getSession().setAttribute(ConstantUtils.SESSION_ACTIVEURI, "space");

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
            // 登录了? 给你放行
            return "space";
        }
    }
}
