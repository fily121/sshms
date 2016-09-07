package cn.com.sinoi.zyqyh.vo;

public class Clxx {

    private String id;

    private String clmc;

    private String cltype;

    private String detail;

    private String clgly;

    private Float clsy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getClmc() {
        return clmc;
    }

    public void setClmc(String clmc) {
        this.clmc = clmc == null ? null : clmc.trim();
    }

    public String getCltype() {
        return cltype;
    }

    public void setCltype(String cltype) {
        this.cltype = cltype == null ? null : cltype.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getClgly() {
        return clgly;
    }

    public void setClgly(String clgly) {
        this.clgly = clgly == null ? null : clgly.trim();
    }

    public Float getClsy() {
        return clsy;
    }

    public void setClsy(Float clsy) {
        this.clsy = clsy;
    }
}
