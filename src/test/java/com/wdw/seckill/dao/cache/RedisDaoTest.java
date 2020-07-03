package com.wdw.seckill.dao.cache;

import com.wdw.seckill.dao.SeckillDao;
import com.wdw.seckill.entity.Seckill;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisDaoTest {
    private long seckillId = 1001;
    @Autowired
    SeckillDao seckillDao;

    @Autowired
    RedisDao redisDao;

    @Test
    public void redisDaoTest() {
        Seckill seckill = redisDao.getSeckill(seckillId);
        if(seckill == null){
            seckill = seckillDao.queryById(seckillId);
            String result = redisDao.setSeckill(seckill);
            Assert.assertEquals(result,"OK");
            seckill = redisDao.getSeckill(seckillId);
            System.out.println(seckill.toString());
            Assert.assertNotNull(seckill);
        }

    }
}