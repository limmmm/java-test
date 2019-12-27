package localdate;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.WeekFields;

/**
 * @author Lim
 * @date 2019/11/5
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MonitorUtil {

    /** 分隔符(周、小时) */
    public static final String SPLIT_CHAR_WEEK = "#";
    /** 分隔符(月、日) */
    public static final String SPLIT_CHAR_MONTH = "-";

    /**
     * Integer 相加
     * 为 null 时默认为0
     * @param a Integer
     * @return 相加结果
     */
    public static Integer add(Integer ...a) {
        int sum = 0;
        if(a == null || a.length == 0) {
            return sum;
        }
        for (Integer integer : a) {
            if(integer != null) {
                sum += integer;
            }
        }
        return sum;
    }

    /**
     * 格式化成周，格式为 yyyy + '#' + w
     * @param date 指定日期
     * @return
     *  eg: 2019#1、2019#52
     */
    public static String getWeek(LocalDate date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("w");
        String weekStr = date.format(dateTimeFormatter);
        int week = Integer.valueOf(weekStr);
        int month = date.getMonthValue();
        int year = date.getYear();

        // 12月且周数为1时，年数加1
        if(week == 1 && month == 12) {
            return String.format("%d%s%d", year + 1, SPLIT_CHAR_WEEK, week);
        }
        // 1月且周数为52时，年份减1
        if(week == 52 && month == 1) {
            return String.format("%d%s%d", year - 1, SPLIT_CHAR_WEEK, week);
        }

        return String.format("%d%s%d", year, SPLIT_CHAR_WEEK, week);
    }

    /**
     * 查询指定日期所在月份的周数
     * @param date 指定日期
     * @return yyyy-MM#WW
     *  eg: 2019-12#01
     */
    public static String getWeekOfMonth(LocalDate date) {

        int weekOfMonth = date.get(ChronoField.ALIGNED_WEEK_OF_MONTH);

        return String.format("%s%s%d", getMonthOfYear(date), SPLIT_CHAR_WEEK, weekOfMonth);
    }

    /**
     * 查询指定日期所在月份的周数
     * 当月满7天才记为第一周，否则算为上一月的最后一周
     * @param date
     * @return
     */
    public static String getWeekOfMonthSeven(LocalDate date) {

        int weekOfMonth = date.get(WeekFields.of(DayOfWeek.SUNDAY, 7).weekOfMonth());

        LocalDate monthDate = date;

        // 若周数为0，则记为上一月的最后一周
        if(weekOfMonth == 0) {
            monthDate = date.withDayOfMonth(1).minusDays(1);
            weekOfMonth = monthDate.get(WeekFields.of(DayOfWeek.SUNDAY, 7).weekOfMonth());
        }


        return String.format("%s%s%d", getMonthOfYear(monthDate), SPLIT_CHAR_WEEK, weekOfMonth);
    }

    /**
     * 查询指定日期所在月份
     * @param date 指定日期
     * @return yyyy-MM
     *  eg: 2019-12
     */
    public static String getMonthOfYear(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM"));
    }

    /**
     * 查询指定日期所在年份
     * @param date 指定日期
     * @return yyyy
     *  eg: 2019
     */
    public static String getYear(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("yyyy"));
    }

    /**
     * 是否包含今天
     * @param start 开始时间
     * @param end 结束时间
     * @return
     *  true：包含
     *  false: 不包含
     */
    public static boolean containsToday(LocalDateTime start, LocalDateTime end) {
        if(start == null || end == null) {
            return false;
        }

        LocalDate sd = start.toLocalDate();
        LocalDate ed = end.toLocalDate();

        LocalDate now = LocalDate.now();

        if(sd.isEqual(now) || ed.isEqual(now) || (sd.isBefore(now) && now.isBefore(ed))) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(getWeekOfMonthSeven(LocalDate.parse("2019-12-27")));
        System.out.println(getWeekOfMonthSeven(LocalDate.parse("2019-12-28")));
        System.out.println(getWeekOfMonthSeven(LocalDate.parse("2019-12-29")));
        System.out.println(getWeekOfMonthSeven(LocalDate.parse("2019-12-30")));
        System.out.println(getWeekOfMonthSeven(LocalDate.parse("2019-12-31")));
        System.out.println(getWeekOfMonthSeven(LocalDate.parse("2020-01-01")));
        System.out.println(getWeekOfMonthSeven(LocalDate.parse("2020-01-02")));
        System.out.println(getWeekOfMonthSeven(LocalDate.parse("2020-01-03")));
        System.out.println(getWeekOfMonthSeven(LocalDate.parse("2020-01-04")));
        System.out.println(getWeekOfMonthSeven(LocalDate.parse("2020-01-05")));
        System.out.println(getWeekOfMonthSeven(LocalDate.parse("2020-01-31")));
        System.out.println(getWeekOfMonthSeven(LocalDate.parse("2020-02-01")));
    }
}
