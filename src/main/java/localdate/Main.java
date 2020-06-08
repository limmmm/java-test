package localdate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;

/**
 * @author: Lim
 * @date: 2019/8/20
 */
public class Main {
    public static void main(String[] args) {
        // 星期
//        dayOfWeek();

        // 格式转换
        str2LocalDateTime();
    }

    private static void str2LocalDateTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        LocalDateTime a = LocalDateTime.parse("2020-03-26T08:42:17.651Z", dateTimeFormatter);
        System.out.println(a);
    }

    private static void dayOfWeek() {
        // 周一
        String d1 = "2019-08-19";
        // 周六
        String d2 = "2019-08-24";
        // 周日
        String d3 = "2019-08-25";

        LocalDate ld1 = LocalDate.parse(d1, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate ld2 = LocalDate.parse(d2, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate ld3 = LocalDate.parse(d3, DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println(ld1.getDayOfWeek().getValue() == DayOfWeek.MONDAY.getValue());
        System.out.println(ld2.getDayOfWeek().getValue() == DayOfWeek.SATURDAY.getValue());
        System.out.println(ld3.getDayOfWeek().getValue() == DayOfWeek.SUNDAY.getValue());

        System.out.println(LocalDate.now().get(WeekFields.of(DayOfWeek.SUNDAY, 1).weekOfYear()));
    }
}
