package com.example.demo.service.impl;

import com.example.demo.dao.CorrectDao;
import com.example.demo.entity.Correct;
import com.example.demo.service.CorrectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CorrectServiceImpl implements CorrectService{

    @Autowired
    private CorrectDao correctDao;
    private List<Correct> L1,L2;

    @Override
    public List<Correct> getAllCorrect()
    {
        return correctDao.getAllCorrect();
    }


    @Override
    public List<Correct> select(Correct correct)
    {
        List<Correct> list=new ArrayList<Correct>();
        L1=list;
        L2=list;
        int a=0;
        if(correctDao.selectNA(correct.Tname).size()!=0) {
            L1 = correctDao.selectNA(correct.Tname);
            a=1;
        }

        if(correctDao.selectNO(correct.Tno).size()!=0)
        {
            if(a==1)
            {
                L2 = correctDao.selectNO(correct.Tno);
                L1.retainAll(L2);
                L2 = null;
            }
            else
            {
                L1 = correctDao.selectNO(correct.Tno);
                a=1;
            }
        }

        if(correctDao.selectA(correct.author).size()!=0)
        {
            if(a==1)
            {
                L2 = correctDao.selectA(correct.author);
                L1.retainAll(L2);
                L2 = null;
            }
            else
            {
                L1 = correctDao.selectA(correct.author);
                a=1;
            }
        }

        if(correctDao.selectD(correct.date).size()!=0)
        {
            if(a==1)
            {
                L2 = correctDao.selectD(correct.date);
                L1.retainAll(L2);
                L2 = null;
            }
            else
            {
                L1 = correctDao.selectD(correct.date);
                a=1;
            }
        }

        if(correctDao.selectAO(correct.acceptornot).size()!=0)
        {
            if(a==1)
            {
                L2 = correctDao.selectAO(correct.acceptornot);
                L1.retainAll(L2);
                L2 = null;
            }
            else
            {
                L1 = correctDao.selectAO(correct.acceptornot);
                a=1;
            }
        }

        if(correctDao.selectAP(correct.acceptpeople).size()!=0)
        {
            if(a==1)
            {
                L2 = correctDao.selectAP(correct.acceptpeople);
                L1.retainAll(L2);
                L2 = null;
            }
            else
            {
                L1 = correctDao.selectAP(correct.acceptpeople);
                a=1;
            }
        }

        if(correctDao.selectT(correct.type).size()!=0)
        {
            if(a==1)
            {
                L2 = correctDao.selectT(correct.type);
                L1.retainAll(L2);
                L2 = null;
            }
            else
            {
                L1 = correctDao.selectT(correct.type);
                a=1;
            }
        }

        if(correctDao.selectTX(correct.text).size()!=0)
        {
            if(a==1)
            {
                L2 = correctDao.selectTX(correct.text);
                L1.retainAll(L2);
                L2 = null;

            }
            else
            {
                L1 = correctDao.selectTX(correct.text);
                a=1;
            }
        }
        return L1;
    }

    @Override
    public boolean insert(Correct correct)
    {
        if(correctDao.search(correct).size()!=0)
            return false;
        correctDao.insert(correct);
        return true;
    }

    @Override
    public boolean update(Correct correct)
    {
        if(correctDao.search(correct).size()==0)
            return false;
        correctDao.update(correct);
        return true;
    }

    @Override
    public boolean delete(Correct correct)
    {
        if(correctDao.search(correct).size()==0)
            return false;
        correctDao.delete(correct.Tno);
        return true;
    }
}
