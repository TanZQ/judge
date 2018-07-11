package com.example.demo.dao;

import com.example.demo.entity.Suggest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SuggestDao {

    @Select(value="select *from Suggest where  besuggested=#{word}")
    List<Suggest>select(String word);

    @Insert(value="insert into Suggest(suggest.id,suggest.`suggestpeople`,suggest.`reason`,suggest.`besuggested`)VALUES(#{id},#{suggestpeople},#{reason},#{besuggested})")
    int insert(Suggest suggest);
}
