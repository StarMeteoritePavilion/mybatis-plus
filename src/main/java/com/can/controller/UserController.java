package com.can.controller;

import com.can.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/insert01")
    public Boolean insert01() {
        return userService.insertUser01();
    }

    @GetMapping("/insert02")
    public Boolean insert02() {
        return userService.insertUser02();
    }

    @GetMapping("/insert03")
    public Boolean insert03() {
        return userService.insertUser03();
    }

    @GetMapping("/insert04")
    public Boolean insert04() {
        return userService.insertUser04();
    }

    @GetMapping("/insert05")
    public Boolean insert05() {
        return userService.insertUser05();
    }

    @GetMapping("/insert06")
    public Boolean insert06() {
        return userService.insertUser06();
    }

}
