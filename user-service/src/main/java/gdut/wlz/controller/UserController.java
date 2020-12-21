package gdut.wlz.controller;

import gdut.wlz.domain.User;
import gdut.wlz.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author: BUG_BOY
 * DATE:2020/11/28  17:34
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @ResponseBody
    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return userService.queryById(id);
    }
}
