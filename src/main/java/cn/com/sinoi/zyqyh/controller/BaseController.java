/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.com.sinoi.zyqyh.controller;

import cn.com.sinoi.zyqyh.definition.editor.DoubleEditor;
import cn.com.sinoi.zyqyh.definition.editor.FloatEditor;
import cn.com.sinoi.zyqyh.definition.editor.IntegerEditor;
import cn.com.sinoi.zyqyh.definition.editor.LongEditor;
import cn.com.sinoi.zyqyh.definition.editor.MyCustomDateEditor;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 *
 * @author Administrator
 */
public class BaseController {

    /**
     *
     * 定义转换器
     *
     * @param binder
     * @see
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class,
                new MyCustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
        binder.registerCustomEditor(int.class, new IntegerEditor());
        binder.registerCustomEditor(long.class, new LongEditor());
        binder.registerCustomEditor(double.class, new DoubleEditor());
        binder.registerCustomEditor(float.class, new FloatEditor());
    }
}
