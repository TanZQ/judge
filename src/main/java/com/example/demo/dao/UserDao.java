package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface UserDao {
    @Select(value = "SELECT * FROM User")
    List<User> getAllUser();

    List<User>select(String word);

    @Select(value = "SELECT username FROM User")

    List<User>search(User user);

    @Insert(value = "INSERT INTO User\n" +
            "VALUE(user)")
    int insert(User user);

    @Update(value = "UPDATE User SET user= #{user} WHERE user.name= #{user.name}")
    int update(User user);

    @Delete(value = "DELETE FROM User WHERE user.name= #{user.name}")
    int delete(User user);
}
