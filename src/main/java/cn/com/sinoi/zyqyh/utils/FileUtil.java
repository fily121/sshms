/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.com.sinoi.zyqyh.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author admin
 */
public class FileUtil {

    public static List<String[]> parseExlToList(MultipartFile userFile) throws IOException, BiffException, IndexOutOfBoundsException {
        //创建一个list 用来存储读取的内容
        List list = new ArrayList();
        Workbook rwb = null;
        Cell cell = null;
        //创建输入流
        InputStream stream = userFile.getInputStream();
        //获取Excel文件对象
        rwb = Workbook.getWorkbook(stream);
        //获取文件的指定工作表 默认的第一个
        Sheet sheet = rwb.getSheet(0);
        //行数(表头的目录不需要，从1开始)
        for (int i = 0; i < sheet.getRows(); i++) {
            //创建一个数组 用来存储每一列的值
            String[] str = new String[sheet.getColumns()];
            //列数
            for (int j = 0; j < sheet.getColumns(); j++) {
                //获取第i行，第j列的值
                cell = sheet.getCell(j, i);
                str[j] = cell.getContents();
            }
            //把刚获取的列存入list
            list.add(str);
        }
        return list;
    }
}
