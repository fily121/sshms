/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.com.sinoi.zyqyh.definition;

/**
 * <p>
 * Title: 文件上传目录枚举映射
 * </p>
 * <p>
 * Description:每个功能上传的附件对应路径的枚举类型，如：订单管理，规章制度等
 * </p>
 *
 * @author 蒋传志
 */
public enum FilePathEnum {

    /**
     * 订单管理
     */
    订单管理("ddgl/"),
    /**
     * 规章制度
     */
    规章制度("gzzd/"),
    /**
     * 材料管理
     */
    材料管理(" clgl/"),
    /**
     * 施工队伍
     */
    施工队伍("sgdgl/"),
    /**
     * 现场管理
     */
    现场管理("xcgl/");

    private final String pathPropertity;

    private FilePathEnum(String pathPropertity) {
        this.pathPropertity = pathPropertity;
    }

    public String getPath() {
        return this.pathPropertity;
    }
}
