/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.com.sinoi.zyqyh.definition;

/**
 *
 * @author Administrator
 */
public enum WeixinMbIdEnum {

    绑定通知("0udqqKzvloebLJ-fMgVlQWRR8ya_SziBIWn3iOKbHJs"),
    异常操作提醒("0-h-oQhOuVh5fpPkMvALNti9DtJnZpEZEc5eNWE_ThY"),
    订单生成通知("8kDiD9vSDYwXDWvUGJuJKL_p-QBsKrVLWci7MTDBcgY");
    private final String templateId;

    public String getTemplateId() {
        return this.templateId;
    }

    private WeixinMbIdEnum(String templateId) {
        this.templateId = templateId;
    }
}
