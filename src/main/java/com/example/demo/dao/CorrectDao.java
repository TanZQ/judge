package com.example.demo.dao;

import com.example.demo.entity.Correct;
import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CorrectDao {
    @Select(value = "SELECT * FROM Correct")

    List<Correct> getAllCorrect();

    @Select(value = "SELECT * FROM Correct WHERE Tno = #{word}")
    List<Correct> selectNO(int word);

    @Select(value = "SELECT * FROM Correct WHERE Tname = #{word}")
    List<Correct> selectNA(String word);

    @Select(value = "SELECT * FROM Correct WHERE author = #{word}")
    List<Correct> selectA(String word);

    @Select(value = "SELECT * FROM Correct WHERE date = #{word}")
    List<Correct> selectD(String word);

    @Select(value = "SELECT * FROM Correct WHERE acceptornot = #{word}")
    List<Correct> selectAO(String word);

    @Select(value = "SELECT * FROM Correct WHERE acceptpeople = #{word}")
    List<Correct> selectAP(String word);

    @Select(value = "SELECT * FROM Correct WHERE type = #{word}")
    List<Correct> selectT(String word);

    @Select(value = "SELECT * FROM Correct WHERE text = #{word}")
    List<Correct> selectTX(String word);


    @Select(value = "SELECT * FROM Correct WHERE correct.`Tno` = #{Tno}")
    List<Correct> search(Correct correct);

    @Insert(value = "INSERT INTO Correct (correct.Tno,correct.`Tname`,correct.`author`,correct.`date`,correct.`acceptornot`,correct.`acceptpeople`,correct.`type`,correct.`text` )VALUES (#{Tno},#{Tname},#{author},#{date},#{acceptornot},#{acceptpeople},#{type},#{text})")
    int insert(Correct correct);

    @Update(value = "UPDATE Correct SET correct.`Tname`=#{Tname},correct.`author`=#{author},correct.`date`=#{date},correct.`acceptornot`=#{acceptornot},correct.`acceptpeople`=#{acceptpeople},correct.`type`=#{type},correct.`text`=#{text} WHERE  correct.Tno=#{Tno}")
    int update(Correct correct);

    @Delete(value = "DELETE FROM Correct WHERE Tno = #{Tno}")
    int delete(int Tno);
}
