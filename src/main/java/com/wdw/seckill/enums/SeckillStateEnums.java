package com.wdw.seckill.enums;

public enum SeckillStateEnums {
    SUCCESS(1,"秒杀成功"),
    END(0,"秒杀结束"),
    REPEAT_KILL(-1,"重复秒杀"),
    INNER_ERROR(-2,"系统异常"),
    DATA_REWRITE(-3,"数据篡改");

    private int state;
    private String sateInfo;

    public int getState() {
        return state;
    }

    public String getSateInfo() {
        return sateInfo;
    }

    SeckillStateEnums(int state, String sateInfo) {
        this.state = state;
        this.sateInfo = sateInfo;
    }

    public static SeckillStateEnums stateOf(int index) {
        for (SeckillStateEnums state : values()) {
            if (index == state.getState()) {
                return state;
            }
        }
        return null;
    }
}
