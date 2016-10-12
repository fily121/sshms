/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.com.sinoi.zyqyh.definition;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 施工专业枚举类。
 */
public enum YonggType {
    正式合同制("1"),
    劳务派遣("2"),
    试用("3"),
    临时("4"),
    外协("5");

    private final String code;

    private YonggType(String code) {
        this.code = code;
    }

    /**
     * 根据传进来的Code找到对应的名字，如果没有找到，就返回空字符串。
     *
     * @param code Code
     * @return 材料类型名字
     */
    public static String getNameByCode(String code) {
        for (YonggType value : YonggType.values()) {
            if (value.code.equals(code)) {
                return value.name();
            }
        }
        return "";
    }

    public String getCode() {
        for (YonggType value : YonggType.values()) {
            if (value.code.equals(code)) {
                return value.code;
            }
        }
        return "";
    }

    public String getName() {
        for (YonggType value : YonggType.values()) {
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
    public static List<YonggType> getList() {
        List<YonggType> result = new ArrayList<>();
        for (YonggType value : YonggType.values()) {
            result.add(value);
        }
        return result;
    }
}
