package excel;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;

import java.util.*;

/**
 * @author Lim
 * @date 2019/11/19
 */
public class Test {
    public static void main(String[] args) {
        ExcelReader reader = ExcelUtil.getReader("d:/data2.xlsx");

        List<List<Object>> readAll = reader.read();

        List<List<Double>> rs = new ArrayList<>();
        List<Data> data = new ArrayList<>();

        Double max = 1.0;
        Double maxa = 1.0;

        for (List<Object> row : readAll) {
            Double a = (Double) row.get(0);
            Double b = (Double) row.get(1);

            if(b > max) {
                max = b;
                maxa = a;
            }
        }

        for (List<Object> row : readAll) {
            List<Double> r = new ArrayList<>();
            Double a = (Double) row.get(0);
            Double b = (Double) row.get(1);
            Double c = (Double) row.get(2);

            if(a < 2.9) {
                b *= 3 - (2.9 - a) * 0.1;
            } else if (a < maxa) {
                b *= 3 - (a - 2.9) / (maxa - 2.9) * 2.0;
            }

            r.add(a);
            r.add(b);
            r.add(c);

            rs.add(r);

            Data d = new Data();
            d.setA(a);
            d.setB(b);
            d.setC(c);
            data.add(d);
        }

        Collections.sort(data);
        Double max2 = data.get(data.size() - 1).getB();
        Map<Double, Double> avg = new HashMap<>();
        for (int i = 0; i < data.size(); i++) {
            if(i > 0 && i< data.size() - 1) {
                avg.put(data.get(i).getB(), (data.get(i-1).getB() + data.get(i).getB() + data.get(i+1).getB())/3);
            }
        }


        List<List<Double>> rs2 = new ArrayList<>();

        for (List<Double> row : rs) {
            List<Double> r = new ArrayList<>();
            Double a = row.get(0);
            Double b = row.get(1);
            Double c = row.get(2);

            if(a > 3.49 && a < 3.53) {
                continue;
            }
            r.add(a);
            if(a > maxa) {
                b = avg.getOrDefault(b, b);
            }
            b = b * max / max2;

            /*b = b * max / max2;
            if(a > maxa && a < 3.5) {
                b += 0.02;
            }
            if(a > 3.48 && a < 3.5) {
                b += 0.015;
            }*/
            r.add(b);
            r.add(c);

            rs2.add(r);
        }

//        System.out.println(rs);

        //通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter("d:/data3.xlsx");

        //跳过当前行，既第一行，非必须，在此演示用
        writer.passCurrentRow();

        //一次性写出内容，强制输出标题
        writer.write(rs2, true);
        //关闭writer，释放内存
        writer.close();

    }
}
