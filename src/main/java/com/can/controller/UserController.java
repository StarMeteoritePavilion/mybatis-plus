package com.can.controller;

import com.can.entity.UserInfo;
import com.can.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <pre>
 *
 * </pre>
 *
 * @author canxin.li
 * @date 2020-10-16 16:15
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/insert")
    public boolean insertUser() {
        return userService.insertUser();
    }

    @GetMapping("/select/{userId}")
    public UserInfo selectUser(@PathVariable("userId")Integer userId) {
        return userService.selectUser(userId);
    }

    @GetMapping("/updateSlow/{userId}")
    public Boolean updateLongTime(@PathVariable("userId")Integer userId) {
        return userService.updateSlowNoIndex(userId);
    }

    @GetMapping("/updateQuick/{userId}")
    public Boolean updateQuick(@PathVariable("userId")Integer userId) {
        return userService.updateQuickNoIndex(userId);
    }


}
