package com.example.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    // 注入Service
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    @SentinelResource(
            value = "/user/list",
            blockHandler = "flowBlockHandler",
            fallback = "degradeFallback"
    )

    public Object list() {
        return userService.listAllUsers();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping("/add")
    public String add(@RequestBody User user) {
        int rows = userService.addUser(user);
        return rows > 0 ? "新增成功" : "新增失败";
    }

    // 限流兜底方法
    public String flowBlockHandler(BlockException e) {
        return "服务接口限流：访问太频繁，请稍后再试";
    }

    // 熔断 & 业务异常降级兜底
    public String degradeFallback() {
        return "服务熔断降级：暂时无法提供服务，请稍后重试";
    }
}
