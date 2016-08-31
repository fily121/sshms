/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.com.sinoi.zyqyh.file;

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
    订单管理("upload.ddgl.path"),
    /**
     * 规章制度
     */
    规章制度("upload.gzzd.path"),
    /**
     * 材料管理
     */
    材料管理("upload.clgl.path"),
    /**
     * 施工队伍
     */
    施工队伍("upload.sgdgl.path"),
    /**
     * 现场管理
     */
    现场管理("upload.xcgl.path");

    private final String pathPropertity;

    private FilePathEnum(String pathPropertity) {
        this.pathPropertity = pathPropertity;
    }

    /**
     * 路径属性值取得。
     *
     * @param pathPropertity 路径属性值
     * @return 路径属性值
     * @throws IllegalArgumentException 该路径不存在
     */
    public static FilePathEnum getPath(String pathPropertity) {
        for (FilePathEnum item : FilePathEnum.values()) {
            if (item.pathPropertity.equals(pathPropertity)) {
                return item;
            }
        }
        throw new IllegalArgumentException("该路径不存在！");

    }

}
