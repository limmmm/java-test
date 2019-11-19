package excel;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lim
 * @date 2019/11/19
 */
public class Test {
    public static void main(String[] args) {
        ExcelReader reader = ExcelUtil.getReader("d:/data2.xlsx");

        List<List<Object>> readAll = reader.read();

        DecimalFormat df = new DecimalFormat("0.000000000000");

        /*List<List<String>> rs = new ArrayList<>();

        for (List<Object> row : readAll) {
            List<String> r = new ArrayList<>();
            Double a = (Double) row.get(0);
            Double b = (Double) row.get(1);
            Double c = (Double) row.get(2);

            r.add(String.valueOf(a));
            if(a > 2.6 && a < 2.8 ) {
                b += 0.1;
            } else if (a < 2.9) {
                b += 0.15;
            } else if (a < 3.0) {
                b += 0.2;
            } else if (a < 3.2) {
                b += 0.25;
            } else if (a < 3.3) {
                b += 0.15;
            } else if (a < 3.4) {
                b += 0.1;
            }
            r.add(df.format(b));
            r.add(df.format(c));

            rs.add(r);
        }*/

        List<List<Double>> rs = new ArrayList<>();

        for (List<Object> row : readAll) {
            List<Double> r = new ArrayList<>();
            Double a = (Double) row.get(0);
            Double b = (Double) row.get(1);
            Double c = (Double) row.get(2);

            r.add(a);
            if(a < 2.6) {
                b *= 1.1;
            } else if(a < 2.7) {
                b *= 1.12;
            } else if (a < 2.8) {
                b *= 1.15;
            } else if (a < 2.9) {
                b *= 1.2;
            } else if (a < 3.0) {
                b *= 1.25;
            } else if(a < 3.05) {
                b *= 1.3;
            } else if (a < 3.1) {
                b *= (1.35 + (a - 3.1) * 0.1);
            } else if (a < 3.15) {
                b *= (1.4 + (a - 3.15) * 0.1);
            } else if (a < 3.2) {
                b *= (1.45 + (a - 3.2)* 0.1);
            } else if (a < 3.25) {
                b *= (1.5 + (a - 3.25)* 0.1);
            } else if (a < 3.3) {
                b *= (1.5 + (a - 3.3)* 0.1);
            }else if (a < 3.35) {
                b *= (1.45 + (a - 3.35)* 0.1);
            } else if (a < 3.4) {
                b *= (1.4 + (a - 3.4)* 0.1);
            } else if (a < 3.45) {
                b *= (1.35 + (a - 3.45)* 0.1);
            } else if (a < 3.5) {
                b *= (1.35 + (a - 3.5)* 0.1);
            } else if (a < 3.55) {
                b *= (1.3 + (a - 3.55)* 0.1);
            } else if (a < 3.6) {
                b *= (1.3 + (a - 3.6)* 0.1);
            } else if (a < 3.65) {
                b *= (1.255 + (a - 3.65)* 0.1);
            }
            r.add(b);
            r.add(c);

            rs.add(r);
        }

//        System.out.println(rs);

        //通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter("d:/data3.xlsx");

        //跳过当前行，既第一行，非必须，在此演示用
        writer.passCurrentRow();

        //一次性写出内容，强制输出标题
        writer.write(rs, true);
        //关闭writer，释放内存
        writer.close();

    }
}
