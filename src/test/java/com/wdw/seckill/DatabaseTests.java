package com.wdw.seckill;

import com.wdw.seckill.dao.SeckillDao;
import com.wdw.seckill.dao.SuccessKilledDao;
import com.wdw.seckill.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("/init-schema.sql")
public class DatabaseTests {
    @Autowired
    SeckillDao seckillDao;

    @Autowired
    SuccessKilledDao successKilledDao;

    @Test
    public void test1(){
        Seckill seckill = seckillDao.queryById(1000);
        System.out.println(seckill.toString());
    }


}
