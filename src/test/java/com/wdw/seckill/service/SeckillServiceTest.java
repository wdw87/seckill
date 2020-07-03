package com.wdw.seckill.service;

import com.wdw.seckill.dto.Exposer;
import com.wdw.seckill.dto.SeckillExecution;
import com.wdw.seckill.entity.Seckill;
import com.wdw.seckill.exception.RepeatKillException;
import com.wdw.seckill.exception.SeckillCloseException;
import com.wdw.seckill.exception.SeckillException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("/init-schema.sql")
public class SeckillServiceTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list = {}", list);
    }

    @Test
    public void getById() {
        Seckill seckill = seckillService.getById(1000);
        logger.info("seckill = {}", seckill);
    }

    @Test
    public void seckillLogic() {
        long id = 1000;
        long phone = 18434368105L;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        try {
            String md5 = exposer.getMd5();
            SeckillExecution seckillExecution = seckillService.executeSeckill(id, phone, md5);
            logger.info("seckillExecution = {}", seckillExecution);
        } catch (SeckillException e) {
            logger.error(e.getMessage());
        } catch (SeckillCloseException e) {
            logger.error(e.getMessage());
        } catch (RepeatKillException e) {
            logger.error(e.getMessage());
        }

    }

    @Test
    public void executeSeckilllProcedure(){
        long seckillId = 1001;
        long phone = 13245678;
        Exposer exposer = seckillService.exportSeckillUrl(seckillId);
        if(exposer.isExposed()){
            String md5 = exposer.getMd5();
            SeckillExecution seckillExecution = seckillService.executeSeckillProcedure(seckillId, phone, md5);
            logger.info(seckillExecution.getStateInfo());

        }
    }

}