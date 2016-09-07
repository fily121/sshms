package cn.com.sinoi.zyqyh.vo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CllqGl {

    private final DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    private String id;

    private String lqclh;

    private String lqtime;

    private Float lqsl;

    private Float sysl;

    private String lqdw;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLqclh() {
        return lqclh;
    }

    public void setLqclh(String lqclh) {
        this.lqclh = lqclh == null ? null : lqclh.trim();
    }

    public String getLqtime() {
        return lqtime;
    }

    public void setLqtime(String lqtime) {
        this.lqtime = lqtime;
    }

    public Float getLqsl() {
        return lqsl;
    }

    public void setLqsl(Float lqsl) {
        this.lqsl = lqsl;
    }

    public Float getSysl() {
        return sysl;
    }

    public void setSysl(Float sysl) {
        this.sysl = sysl;
    }

    public String getLqdw() {
        return lqdw;
    }

    public void setLqdw(String lqdw) {
        this.lqdw = lqdw == null ? null : lqdw.trim();
    }
}
