package com.wdw.seckill.dao;

import com.wdw.seckill.entity.SuccessKilled;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;



@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("/init-schema.sql")
public class SuccessKilledDaoTest {

    @Autowired
    private SeckillDao seckillDao;

    @Autowired
    private SuccessKilledDao successKilledDao;

    @Test
    public void insertSuccessKilled() {
        int res = successKilledDao.insertSuccessKilled(1000L,18434368105L);
        Assert.assertEquals(res,1);
        res = successKilledDao.insertSuccessKilled(1000L,18434368105L);
        Assert.assertEquals(res,0);
    }

    @Test
    public void queryByIdWithSeckill() {
        successKilledDao.insertSuccessKilled(1000L,18434368105L);

        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(1000L,18434368105L);
        System.out.println(successKilled.toString());
        System.out.println(successKilled.getSecKill().toString());

    }
}