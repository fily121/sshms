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
 * 资质证书枚举类。
 */
public enum Certificate {
    移动岗位资质证("1"),
    安全员证("2"),
    登高证("3"),
    电工证("4"),
    焊工证("5"),
    制冷证("6");

    private final String code;

    private Certificate(String code) {
        this.code = code;
    }

    /**
     * 根据传进来的Code找到对应的名字，如果没有找到，就返回空字符串。
     *
     * @param code Code
     * @return 材料类型名字
     */
    public static String getNameByCode(String code) {
        for (Certificate value : Certificate.values()) {
            if (value.code.equals(code)) {
                return value.name();
            }
        }
        return "";
    }

    public String getCode() {
        for (Certificate value : Certificate.values()) {
            if (value.code.equals(code)) {
                return value.code;
            }
        }
        return "";
    }

    public String getName() {
        for (Certificate value : Certificate.values()) {
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
    public static List<Certificate> getList() {
        List<Certificate> result = new ArrayList<>();
        result.addAll(Arrays.asList(Certificate.values()));
        return result;
    }
}
