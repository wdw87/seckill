package com.wdw.seckill.service;

import com.wdw.seckill.dto.Exposer;
import com.wdw.seckill.dto.SeckillExecution;
import com.wdw.seckill.entity.Seckill;
import com.wdw.seckill.exception.RepeatKillException;
import com.wdw.seckill.exception.SeckillCloseException;
import com.wdw.seckill.exception.SeckillException;

import java.util.List;

/**
 *
 */
public interface SeckillService {
    /**
     * 查询秒杀列表
     *
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀记录
     *
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);

    /**
     * 秒杀开始时输出秒杀地址接口
     * 否则输出系统时间和秒杀时间
     *
     * @param seckillId
     * @return
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     * @throws SeckillException
     * @throws SeckillCloseException
     * @throws RepeatKillException
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws SeckillException, SeckillCloseException, RepeatKillException;

    SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5);
}
