package com.lim.test.excel;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;

import java.util.List;

/**
 * Excel 操作
 *
 * @author lim
 * @date 2019/11/19
 */
public class Excel {

    // excel 读写操作
    public static void readAndWrite() {

        // 从excel中读取
        ExcelReader reader = ExcelUtil.getReader("D:/data.xlsx");
        List<UserSalary> userSalaryList = reader.readAll(UserSalary.class);

        // 业务操作
        for (UserSalary userSalary : userSalaryList) {
            userSalary.setSalary(userSalary.getSalary() + userSalary.getAge());
        }

        // 写入到excel
        // 通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter("D:/rs.xlsx");

        // 跳过当前行，既第一行，非必须，在此演示用
        writer.passCurrentRow();

        //一次性写出内容，强制输出标题
        writer.write(userSalaryList, true);
        //关闭writer，释放内存
        writer.close();

    }

}
