package com.example.demo.service.impl;

import com.example.demo.dao.SuggestDao;
import com.example.demo.entity.Suggest;
import com.example.demo.service.SuggestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SuggestServiceImpl implements SuggestService {

    @Autowired
    private SuggestDao suggestDao;

    @Override
    public List<Suggest>select(String word)
    {
        return suggestDao.select(word);
    }

    @Override
    public boolean insert(Suggest suggest)
    {
        suggestDao.insert(suggest);
        return true;
    }
}
