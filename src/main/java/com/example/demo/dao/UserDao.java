package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface UserDao {
    @Select(value = "SELECT * FROM User")
    List<User> getAllUser();

    @Select(value = "SELECT * FROM User WHERE  username = #{word}")
    List<User>selectU(String word);

    @Select(value = "SELECT * FROM User WHERE  password = #{word}")
    List<User>selectP(String word);

    @Select(value = "SELECT * FROM User WHERE  name = #{word}")
    List<User>selectN(String word);

    @Select(value = "SELECT * FROM User WHERE  sex = #{word}")
    List<User>selectS(String word);

    @Select(value = "SELECT * FROM User WHERE  dateofbirth = #{word}")
    List<User>selectD(String word);

    @Select(value = "SELECT * FROM User WHERE  address = #{word}")
    List<User>selectA(String word);

    @Select(value = "SELECT * FROM User WHERE  phoneno = #{word}")
    List<User>selectPN(String word);

    @Select(value = "SELECT * FROM User WHERE  leader = #{word}")
    List<User>selectL(String word);

    @Select(value = "SELECT * FROM User WHERE  community = #{word}")
    List<User>selectC(String word);

    @Select(value = "SELECT * FROM User WHERE  company = #{word}")
    List<User>selectCO(String word);

    @Select(value = "SELECT * FROM User WHERE  identity = #{word}")
    List<User>selectI(String word);

    @Select(value = "SELECT * FROM User WHERE  useornot = #{word}")
    List<User>selectUN(String word);



    @Select(value = "SELECT * FROM User WHERE user.`username` = #{username}")
    List<User>search(User user);

    @Insert(value = "INSERT INTO User (user.id ,user.`username`,user.`password`,user.`name`,user.`sex`,user.`dateofbirth`,user.`address`,user.`phoneno`,user.`leader`,user.`community`,user.`company`,user.`identity`,user.`useornot`)VALUES (#{id},#{username},#{password},#{name},#{sex},#{dateofbirth},#{address},#{phoneno},#{leader},#{community},#{company},#{identity},#{useornot})")
    int insert(User user);

    @Update(value = "UPDATE User SET  user.id =#{id},user.`password` = #{password},user.`name` = #{name},user.`sex`=#{sex},user.`dateofbirth` =#{dateofbirth},user.`address`=#{address},user.`phoneno`=#{phoneno},user.`leader`=#{leader},user.`community`=#{community},user.`company`=#{company},user.`identity`=#{identity},user.`useornot`=#{useornot}  WHERE  user.`username`= #{username}")
    int update(User user);

    @Delete(value = "DELETE FROM User WHERE username = #{username}")
    int delete(String username);
}
