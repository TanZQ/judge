package com.example.demo.service.impl;

import com.example.demo.dao.CorrectDao;
import com.example.demo.entity.Correct;
import com.example.demo.service.CorrectService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CorrectServiceImpl implements CorrectService{

    @Autowired
    private CorrectDao correctDao;

    @Override
    public List<Correct> getAllCorrect()
    {
        return correctDao.getAllCorrect();
    }

    @Override
    public List<Correct> select(Correct correct)
    {
        return correctDao.select(correct);
    }

    @Override
    public boolean insert(Correct correct)
    {
        if(correctDao.search(correct)!=null)
            return false;
        correctDao.insert(correct);
        return true;
    }

    @Override
    public boolean update(Correct correct)
    {
        if(correctDao.search(correct)==null)
            return false;
        correctDao.update(correct);
        return true;
    }

    @Override
    public boolean delete(Correct correct)
    {
        if(correctDao.search(correct)==null)
            return false;
        correctDao.delete(correct);
        return true;
    }
}
