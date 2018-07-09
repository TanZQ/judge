package com.example.demo.service.impl;

import com.example.demo.dao.CorrectDao;
import com.example.demo.entity.Correct;
import com.example.demo.service.CorrectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CorrectServiceImpl implements CorrectService{

    @Autowired
    private CorrectDao correctDao;
    private List<Correct> L1,L2;
    private String Tno;

    @Override
    public List<Correct> getAllCorrect()
    {
        return correctDao.getAllCorrect();
    }

    @Override
    public List<Correct> select(Correct correct)
    {
        if(correctDao.select(correct.Tname)!=null)
            L1=correctDao.select(correct.Tname);
        Tno=Integer.toString(correct.Tno);
        if(correctDao.select(Tno)!=null)
        {
            L2 = correctDao.select(Tno);
            L1.retainAll(L2);
            L2 = null;
        }
        if(correctDao.select(correct.author)!=null)
        {
            L2 = correctDao.select(correct.author);
            L1.retainAll(L2);
            L2 = null;
        }
        if(correctDao.select(correct.date)!=null)
        {
            L2 = correctDao.select(correct.date);
            L1.retainAll(L2);
            L2 = null;
        }
        if(correctDao.select(correct.acceptornot)!=null)
        {
            L2 = correctDao.select(correct.acceptornot);
            L1.retainAll(L2);
            L2 = null;
        }
        if(correctDao.select(correct.acceptpeople)!=null)
        {
            L2 = correctDao.select(correct.acceptpeople);
            L1.retainAll(L2);
            L2 = null;
        }
        if(correctDao.select(correct.type)!=null)
        {
            L2 = correctDao.select(correct.type);
            L1.retainAll(L2);
            L2 = null;
        }
        if(correctDao.select(correct.text)!=null)
        {
            L2 = correctDao.select(correct.text);
            L1.retainAll(L2);
            L2 = null;
        }




        return L1;
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
