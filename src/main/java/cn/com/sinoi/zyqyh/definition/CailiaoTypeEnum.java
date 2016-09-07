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
 * Title: 定义材料的类型
 * </p>
 * <p>
 * Description:每一种材料类型对应一个Code值。
 * </p>
 *
 * @author 杜保军
 */
public enum CailiaoTypeEnum {

    未知类型("00", "未知类型"),
    类型1("01", "类型1"),
    类型2("02", "类型2"),
    类型3("03", "类型3"),
    类型4("04", "类型4"),
    类型5("05", "类型5");

    private final String code;
    private final String name;

    /**
     * 根据传进来的Code找到对应的名字，如果没有找到，就返回空字符串。
     *
     * @param code Code
     * @return 材料类型名字
     */
    public String getNameByCode(String code) {
        for (CailiaoTypeEnum value : CailiaoTypeEnum.values()) {
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
        for (CailiaoTypeEnum value : CailiaoTypeEnum.values()) {
            map.put(value.code, value.name);
        }
        return map;
    }

    private CailiaoTypeEnum(String code, String name) {
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
