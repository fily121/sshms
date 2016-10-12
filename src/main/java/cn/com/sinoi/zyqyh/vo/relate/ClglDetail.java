/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.com.sinoi.zyqyh.vo.relate;

import cn.com.sinoi.zyqyh.vo.CllqGl;
import cn.com.sinoi.zyqyh.vo.Clxx;
import cn.com.sinoi.zyqyh.vo.Sgdxx;

/**
 * 材料管理类
 *
 * @author LDNS 杜保軍
 */
public class ClglDetail {

    private CllqGl cllqGl;
    private Clxx clxx;
    private Sgdxx sgdxx;

    public CllqGl getCllqGl() {
        return cllqGl;
    }

    public void setCllqGl(CllqGl cllqGl) {
        this.cllqGl = cllqGl;
    }

    public Clxx getClxx() {
        return clxx;
    }

    public void setClxx(Clxx clxx) {
        this.clxx = clxx;
    }

    public Sgdxx getSgdxx() {
        return sgdxx;
    }

    public void setSgdxx(Sgdxx sgdxx) {
        this.sgdxx = sgdxx;
    }

}
