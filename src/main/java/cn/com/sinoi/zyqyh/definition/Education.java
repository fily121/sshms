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
 * 文化程度枚举类。
 */
public enum Education {
    初中("1"),
    高中("2"),
    本科("3"),
    硕士("4"),
    博士("5");

    private final String code;

    private Education(String code) {
        this.code = code;
    }

    /**
     * 根据传进来的Code找到对应的名字，如果没有找到，就返回空字符串。
     *
     * @param code Code
     * @return 材料类型名字
     */
    public static String getNameByCode(String code) {
        for (Education value : Education.values()) {
            if (value.code.equals(code)) {
                return value.name();
            }
        }
        return "";
    }

    public String getCode() {
        for (Education value : Education.values()) {
            if (value.code.equals(code)) {
                return value.code;
            }
        }
        return "";
    }

    public String getName() {
        for (Education value : Education.values()) {
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
    public static List<Education> getList() {
        List<Education> result = new ArrayList<>();
        result.addAll(Arrays.asList(Education.values()));
        return result;
    }
}
