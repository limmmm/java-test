package com.lim.test.localdate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.WeekFields;

/**
 * 日期计算辅助类
 *
 * @author lim
 * @date 2020/1/29
 */
public class LocalDateUtil {

    /** 分隔符(周、小时) */
    public static final String SPLIT_CHAR_WEEK = "#";
    /** 分隔符(月、日) */
    public static final String SPLIT_CHAR_MONTH = "-";

    /**
     * 周开始日期，周日为周开始时间
     *
     * @param date 指定日期
     * @return LocalDate
     *      eg: 2019-11-10  -> 2019-11-10
     */
    public static LocalDate getStartOfWeek(LocalDate date) {
        return date.minusDays(date.getDayOfWeek().getValue() % 7);
    }

    /**
     * 周结束日期，周日为周开始时间
     *
     * @param date 指定日期
     * @return LocalDate
     *      eg: 2019-11-10  -> 2019-11-16
     */
    public static LocalDate getEndOfWeek(LocalDate date) {
        return date.plusDays(7 - 1 - date.getDayOfWeek().getValue() % 7);
    }

    /**
     * 上一周的同一天
     *
     * @param date 指定日期
     * @return LocalDate
     *      eg: 2019-12-18 -> 2019-12-11
     */
    public static LocalDate getBeforeWeek(LocalDate date) {
        return date.minusDays(7);
    }

    /**
     * 月开始日期
     * @param date 指定日期
     * @return LocalDate
     *  eg: 2019-11-10  -> 2019-11-16
     */
    public static LocalDate getStartOfMonth(LocalDate date) {
        return date.withDayOfMonth(1);
    }

    /**
     * 月结束日期
     * @param date 指定日期
     * @return LocalDate
     *  eg: 2019-11-10  -> 2019-11-30
     */
    public static LocalDate getEndOfMonth(LocalDate date) {
        return date.withDayOfMonth(date.lengthOfMonth());
    }

    /**
     * 上一月的同一天
     *
     * @param alwaysAtEnd 当 {@code date} 为最后一天时，上一月是否也要是最后一天
     *                    true: 要求为最后一天
     *                    false: 不要求为最后一天
     * @param date 指定日期
     * @return LocalDate
     *   eg: （true, 2019-12-18) -> 2019-11-18
     *      (true, 2019-12-31) -> 2019-11-30
     *      (true, 2019-11-30) -> 2019-10-31
     *      (false, 2019-11-30) -> 2019-10-30
     */
    public static LocalDate getBeforeMonth(boolean alwaysAtEnd, LocalDate date) {
        if (alwaysAtEnd && date.lengthOfMonth() == date.getDayOfMonth()) {
            // 需要同为最后一天且为最有一天
            LocalDate before = date.minusMonths(1);
            return before.withDayOfMonth(before.lengthOfMonth());
        } else {
            // 不要求一定为最后一天 或者 不是最后一天
            return date.minusMonths(1);
        }
    }

    /**
     * 格式化成周，格式为 yyyy + '#' + w
     * 周日为一周的开始
     *
     * @param date 指定日期
     * @return
     *      eg: 2019#1、2019#52
     */
    public static String getWeekOfYear(LocalDate date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("w");
        String weekStr = date.format(dateTimeFormatter);
        int week = Integer.parseInt(weekStr);
        int month = date.getMonthValue();
        int year = date.getYear();

        // 12月且周数为1时，年数加1
        if(week == 1 && month == 12) {
            return String.format("%d%s%d", year + 1, SPLIT_CHAR_WEEK, week);
        }
        // 1月且周数为52或53时，年份减1
        if(week >= 52 && month == 1) {
            return String.format("%d%s%d", year - 1, SPLIT_CHAR_WEEK, week);
        }

        return String.format("%d%s%d", year, SPLIT_CHAR_WEEK, week);
    }

    /**
     * 查询指定日期所在月份的周数
     *
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
     * @param date 指定日期
     * @return yyyy-MM#WW
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

}
