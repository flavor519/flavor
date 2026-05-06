package com.example.mapper;
import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UserMapper {

    // 查询所有用户
    List<User> selectAll();

    // 根据ID查询用户
    User selectById(Integer id);

    // 新增用户
    int insert(User user);

    // 修改用户
    int update(User user);

    // 删除用户
    int deleteById(Integer id);
}