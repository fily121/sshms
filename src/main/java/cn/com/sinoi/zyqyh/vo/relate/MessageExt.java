/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.com.sinoi.zyqyh.vo.relate;

import cn.com.sinoi.zyqyh.vo.Message;

/**
 * 消息扩展类
 *
 * @author 强成西
 */
public class MessageExt extends Message {

    private String userFullName;
    private String sgdmc;
    private String formattedTime;

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getSgdmc() {
        return sgdmc;
    }

    public void setSgdmc(String sgdmc) {
        this.sgdmc = sgdmc;
    }

    public String getFormattedTime() {
        return formattedTime;
    }

    public void setFormattedTime(String formattedTime) {
        this.formattedTime = formattedTime;
    }

}
