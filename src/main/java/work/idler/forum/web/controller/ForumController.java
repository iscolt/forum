package work.idler.forum.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import work.idler.forum.domain.Forum;
import work.idler.forum.service.ForumService;

import java.util.ArrayList;
import java.util.List;

/**
 * 论坛控制器
 *
 * @Auther:https://blog.idler.work
 * @Date:2019/5/9
 * @Description:work.idler.forum.web.controller
 * @version:1.0
 */
@Controller
@RequestMapping(value = "forums")
public class ForumController {

    @Autowired
    private ForumService forumService;

}
