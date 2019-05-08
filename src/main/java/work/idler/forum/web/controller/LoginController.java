package work.idler.forum.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import work.idler.forum.commons.constant.ConstantUtils;
import work.idler.forum.domain.User;
import work.idler.forum.service.UserService;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户登录控制器
 *
 * @Auther:https://blog.idler.work
 * @Date:2019/5/8
 * @Description:work.idler.forum.web.controller
 * @version:1.0
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    /**
     * 登录逻辑
     * @param account
     * @param password
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String account, @RequestParam(required = true)  String password, HttpServletRequest httpServletRequest, Model model){
        User user = userService.findByUserNameAndUserPass(account, password);

        // 登录失败
        if (user == null) {
            model.addAttribute("message", "用户名或密码错误, 请重新输入! ");
            return login();
        }

        // 登录成功
        else {
            // 将登录信息放入会话
            httpServletRequest.getSession().setAttribute(ConstantUtils.SESSION_USER, user);
            return "redirect:/main";
        }
    }

    /**
     * 注销
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest httpServletRequest){
        httpServletRequest.getSession().invalidate();
        return login();
    }
}
