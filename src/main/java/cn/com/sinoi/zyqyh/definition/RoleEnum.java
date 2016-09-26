/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.com.sinoi.zyqyh.definition;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Title: 定义角色的类型
 * </p>
 * <p>
 * Description:每一种角色类型对应一个Code值。
 * </p>
 *
 * @author 杜保军
 */
public enum RoleEnum {

    管理员用户("1", "管理员用户"),
    普通用户("2", "普通用户"),
    施工队长("3", "施工队长");

    private final String code;
    private final String name;

    public static RoleEnum fromCode(String code) {
        for (RoleEnum value : RoleEnum.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        return null;
    }

    /**
     * 根据传进来的Code找到对应的名字，如果没有找到，就返回空字符串。
     *
     * @param code Code
     * @return 材料类型名字
     */
    public String getNameByCode(String code) {
        for (RoleEnum value : RoleEnum.values()) {
            if (value.code.equals(code)) {
                return value.name;
            }
        }
        return "";
    }

    /**
     * 获取所有的材料类型，在追加和修正材料信息时作为下拉框。
     *
     * @return 材料类型
     */
    public Map<String, String> getAllCailiaoTypes() {
        Map<String, String> map = new HashMap<>();
        for (RoleEnum value : RoleEnum.values()) {
            map.put(value.code, value.name);
        }
        return map;
    }

    private RoleEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

}
