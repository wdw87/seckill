package com.wdw.seckill.dao;

import com.wdw.seckill.entity.Seckill;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("/init-schema.sql")
public class SeckillDaoTest {

    @Autowired
    SeckillDao seckillDao;

    @Test
    public void reduceNumber() {
        seckillDao.reduceNumber(1000,new Date());
        Seckill seckill = seckillDao.queryById(1000);
        Assert.assertEquals(99,seckill.getNumber());
    }

    @Test
    public void queryById() {
        Seckill seckill = seckillDao.queryById(1000);
        System.out.println(seckill.toString());
    }

    @Test
    public void queryAll() {
        List<Seckill> items = new ArrayList<>();
        items = seckillDao.queryAll(1,3);
        for(Seckill item : items){
            System.out.println(item.toString());
        }
    }
}