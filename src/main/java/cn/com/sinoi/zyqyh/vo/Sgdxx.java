package cn.com.sinoi.zyqyh.vo;

public class Sgdxx {

    private String id;

    private String sgdmc;

    private String detail;

    private String address;

    private String ctype;

    private String duizhang;

    private String duizhangMc;

    private String cph;

    public String getCph() {
        return cph;
    }

    public void setCph(String cph) {
        this.cph = cph;
    }

    public String getDuizhangMc() {
        return duizhangMc;
    }

    public void setDuizhangMc(String duizhangMc) {
        this.duizhangMc = duizhangMc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSgdmc() {
        return sgdmc;
    }

    public void setSgdmc(String sgdmc) {
        this.sgdmc = sgdmc == null ? null : sgdmc.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public String getDuizhang() {
        return duizhang;
    }

    public void setDuizhang(String duizhang) {
        this.duizhang = duizhang == null ? null : duizhang.trim();
    }
}
