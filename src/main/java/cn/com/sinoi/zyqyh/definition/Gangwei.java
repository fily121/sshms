/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.com.sinoi.zyqyh.definition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 施工专业枚举类。
 */
public enum Gangwei {
    安全员("1"),
    施工队长("2");

    private final String code;

    private Gangwei(String code) {
        this.code = code;
    }

    /**
     * 根据传进来的Code找到对应的名字，如果没有找到，就返回空字符串。
     *
     * @param code Code
     * @return 材料类型名字
     */
    public static String getNameByCode(String code) {
        for (Gangwei value : Gangwei.values()) {
            if (value.code.equals(code)) {
                return value.name();
            }
        }
        return "";
    }

    public String getCode() {
        for (Gangwei value : Gangwei.values()) {
            if (value.code.equals(code)) {
                return value.code;
            }
        }
        return "";
    }

    public String getName() {
        for (Gangwei value : Gangwei.values()) {
            if (value.code.equals(code)) {
                return value.name();
            }
        }
        return "";
    }

    /**
     * 枚举值列表。
     *
     * @return
     */
    public static List<Gangwei> getList() {
        List<Gangwei> result = new ArrayList<>();
        result.addAll(Arrays.asList(Gangwei.values()));
        return result;
    }
}
