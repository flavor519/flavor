package com.example.service.impl;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

// 标记为Service层组件，Spring会自动管理
@Service
public class UserServiceImpl implements UserService {

    // 注入Mapper（数据库操作对象）
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listAllUsers() {
        // 直接调用Mapper的方法，返回查询结果
        return userMapper.selectAll();
    }

    @Override
    public User getUserById(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("用户ID不合法");
        }
        return userMapper.selectById(id);
    }

    @Override
    public int addUser(User user) {
        // 可以在这里做业务校验
        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            throw new IllegalArgumentException("用户名不能为空");
        }
        if (user.getPassword() == null || user.getPassword().length() < 6) {
            throw new IllegalArgumentException("密码长度不能少于6位");
        }
        return userMapper.insert(user);
    }

    @Override
    public int updateUser(User user) {
        // 业务校验：ID必须存在
        if (user.getId() == null || user.getId() <= 0) {
            throw new IllegalArgumentException("用户ID不合法");
        }
        return userMapper.update(user);
    }

    @Override
    // 加事务注解：方法执行失败会自动回滚数据库操作
    @Transactional(rollbackFor = Exception.class)
    public int deleteUser(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("用户ID不合法");
        }
        return userMapper.deleteById(id);
    }
}