package datetime;

import jdk.nashorn.internal.runtime.ECMAException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @author Lim
 * @date 2020/1/29
 */
public class Main {

    /** 源日期格式 */
    private static final DateTimeFormatter FORMATTER_SRC = DateTimeFormatter.ofPattern("M/d/yy");

    /** 目标日期格式*/
    private static final DateTimeFormatter FORMATTER_DES = DateTimeFormatter.ofPattern("yyyy/M/d");

    public static void main(String[] args) {
/*        String a = "1/5/20";
        String b = "1/15/20";
        String c = "10/5/20";
        String d = "10/15/20";
        String e = "2020/1/5";


        System.out.println(convertDate(a));
        System.out.println(convertDate(b));
        System.out.println(convertDate(c));
        System.out.println(convertDate(d));
        System.out.println(convertDate(e));*/

        convertToMills();

    }

    private static String convertDate(String dateStr) {

        try {
            LocalDate date = LocalDate.parse(dateStr, FORMATTER_SRC);
            return date.format(FORMATTER_DES);
        } catch (Exception e) {
            return dateStr;
        }
    }

    private static void convertToMills() {
        LocalDateTime now = LocalDateTime.now();

        System.out.println(now.toInstant(ZoneOffset.ofHours(8)).toEpochMilli());
    }
}
