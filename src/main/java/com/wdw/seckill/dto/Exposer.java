package com.wdw.seckill.dto;

public class Exposer {
    //是否开启秒杀
    private boolean exposed;
    //加密
    private String md5;
    //秒杀id
    private long seekillId;
    //系统当前时间（毫秒）
    private long now;
    //开启时间
    private long start;
    //结束时间
    private long end;

    public Exposer(boolean exposed, String md5, long seekillId) {
        this.exposed = exposed;
        this.md5 = md5;
        this.seekillId = seekillId;
    }

    public Exposer(boolean exposed, long seekillId, long now, long start, long end) {
        this.exposed = exposed;
        this.seekillId = seekillId;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    public Exposer(boolean exposed, long seekillId) {
        this.exposed = exposed;
        this.seekillId = seekillId;
    }

    public boolean isExposed() {
        return exposed;
    }

    @Override
    public String toString() {
        return "Exposer{" +
                "exposed=" + exposed +
                ", md5='" + md5 + '\'' +
                ", seekillId=" + seekillId +
                ", now=" + now +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public long getSeekillId() {
        return seekillId;
    }

    public void setSeekillId(long seekillId) {
        this.seekillId = seekillId;
    }

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }
}
