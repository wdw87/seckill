-- 数据库初始化脚本

-- CREATE DATABASE seckill;
-- user seckill;
-- 秒杀库存表
DROP TABLE IF EXISTS `seckill`;
CREATE TABLE `seckill` (
  `seckill_id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(120) NOT NULL,
  `number` INT NOT NULL,
  `start_time` TIMESTAMP NOT NULL,
  `end_time` TIMESTAMP NOT NULL,
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`seckill_id`),
  INDEX `idx_start_time` (`start_time` ASC) INVISIBLE,
  INDEX `idx_end_time` (`end_time` ASC) INVISIBLE,
  INDEX `idx_create_time` (`create_time` ASC) INVISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 1000
DEFAULT CHARACTER SET = utf8
COMMENT = '秒杀库存表';

insert into seckill(name,number,start_time,end_time) values
('1000元秒杀iPhone10',100000,'2020-6-8 20:45:00','2020-8-28 00:00:00'),
('500元秒杀iPad2',200,'2020-6-9 20:45:00','2020-8-28 00:00:00'),
('300元秒杀小米',300,'2020-6-9 20:45:00','2020-8-28 00:00:00'),
('200元秒杀红米',400,'2020-6-9 20:45:00','2020-8-28 00:00:00');


-- 秒杀明细表
DROP TABLE IF EXISTS `success_killed`;
CREATE TABLE `success_killed` (
  `seckill_id` INT NOT NULL,
  `user_phone` BIGINT NOT NULL,
  `state` TINYINT NOT NULL DEFAULT -1 COMMENT '状态表示: -1:无效 0:成功 1: 已付款 2: 已发货',
  `create_time` TIMESTAMP NOT NULL DEFAULT NOW(),
  INDEX `idx_create_time` (`create_time` ASC) VISIBLE,
  PRIMARY KEY (`seckill_id`, `user_phone`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '秒杀成功明细表';