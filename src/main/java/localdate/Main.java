package localdate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author: Lim
 * @date: 2019/8/20
 */
public class Main {
    public static void main(String[] args) {
        String d1 = "2019-08-19"; // 周一
        String d2 = "2019-08-24"; // 周六
        String d3 = "2019-08-25"; // 周日

        LocalDate ld1 = LocalDate.parse(d1, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate ld2 = LocalDate.parse(d2, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate ld3 = LocalDate.parse(d3, DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println(ld1.getDayOfWeek().getValue() == DayOfWeek.MONDAY.getValue());
        System.out.println(ld2.getDayOfWeek().getValue() == DayOfWeek.SATURDAY.getValue());
        System.out.println(ld3.getDayOfWeek().getValue() == DayOfWeek.SUNDAY.getValue());
    }
}
