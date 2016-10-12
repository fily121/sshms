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
public enum MajorEnum {
    基站设备("1"),
    基站土建("2"),
    铁塔安装("3"),
    传输设备("4"),
    传输管线("5"),
    宽带接入("6"),
    综合覆盖("7"),
    电源配套("8");

    private final String code;

    private MajorEnum(String code) {
        this.code = code;
    }

    /**
     * 根据传进来的Code找到对应的名字，如果没有找到，就返回空字符串。
     *
     * @param code Code
     * @return 材料类型名字
     */
    public static String getNameByCode(String code) {
        for (MajorEnum value : MajorEnum.values()) {
            if (value.code.equals(code)) {
                return value.name();
            }
        }
        return "";
    }

    public String getCode() {
        for (MajorEnum value : MajorEnum.values()) {
            if (value.code.equals(code)) {
                return value.code;
            }
        }
        return "";
    }

    public String getName() {
        for (MajorEnum value : MajorEnum.values()) {
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
    public static List<MajorEnum> getList() {
        List<MajorEnum> result = new ArrayList<>();
        result.addAll(Arrays.asList(MajorEnum.values()));
        return result;
    }
}
