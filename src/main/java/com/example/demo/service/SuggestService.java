package com.example.demo.service;

import com.example.demo.entity.Suggest;

import java.util.List;

public interface SuggestService {

    List<Suggest>select(String word);

    boolean insert(Suggest suggest);
}
