package com.example.service;


import com.example.entity.User;
import java.util.List;

// 定义业务方法接口
public interface UserService {
    // 查询所有用户
    List<User> listAllUsers();

    // 根据ID查询单个用户
    User getUserById(Integer id);

    // 新增用户
    int addUser(User user);

    // 修改用户
    int updateUser(User user);

    // 删除用户
    int deleteUser(Integer id);
}