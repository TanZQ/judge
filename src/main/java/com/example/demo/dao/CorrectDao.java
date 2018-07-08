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

    List<Correct> select(String word);

    @Select(value = "SELECT Tno FROM Correct")
    List<Correct> search(Correct correct);

    @Insert(value = "INSERT INTO Correct\n" +
            "VALUE(correct)")
    int insert(Correct correct);

    @Update(value = "UPDATE Correct SET correct= #{correct} WHERE correct.Tname= #{correct.Tname}")
    int update(Correct correct);

    @Delete(value = "DELETE FROM Correct WHERE correct.Tname= #{Correct.Tname}")
    int delete(Correct correct);
}
