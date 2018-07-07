package com.example.demo.service;


import com.example.demo.entity.Correct;

import java.util.List;

public interface CorrectService {

    List<Correct> getAllCorrect();

    List<Correct> select(Correct correct);

    boolean insert(Correct correct);

    boolean update(Correct correct);

    boolean delete(Correct correct);
}
