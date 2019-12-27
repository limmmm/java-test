package localdate;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.regex.Matcher;

/**
 * 日期计算辅助类
 * @author Lim
 * @date 2019/11/10
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocalDateUtil {

    /**
     * 周开始日期，周日为周开始时间
     * @param date 指定日期
     * @return LocalDate
     *  eg: 2019-11-10  -> 2019-11-10
     */
    public static LocalDate getStartOfWeek(LocalDate date) {
        return date.minusDays(date.getDayOfWeek().getValue() % 7);
    }

    /**
     * 周结束日期，周日为周开始时间
     * @param date 指定日期
     * @return LocalDate
     *  eg: 2019-11-10  -> 2019-11-16
     */
    public static LocalDate getEndOfWeek(LocalDate date) {
        return date.plusDays(7 - 1 - date.getDayOfWeek().getValue() % 7);
    }

    /**
     * 上一周的开始时间
     * @param date 指定日期
     * @return LocalDate
     *  eg: 2019-12-18 -> 2019-12-08
     */
    public static LocalDate getStartOfBeforeWeek(LocalDate date) {
        date = date.minusDays(7);
        return getStartOfWeek(date);
    }

    /**
     * 上一周的同一天
     * @param date 指定日期
     * @return LocalDate
     *   eg: 2019-12-18 -> 2019-12-11
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
     * 上一月开始日期
     * @param date 指定日期
     * @return LocalDate
     *  eg: 2019-12-18 -> 2019-11-01
     */
    public static LocalDate getStartOfBeforeMonth(LocalDate date) {
        // 先定位到指定月1日，后减15天至上一月，在查询上一月1号
        date = date.withDayOfMonth(1);
        date = date.minusDays(15);
        return getStartOfMonth(date);
    }

    /**
     * 上一月的同一天
     * @param date 指定日期
     * @return LocalDate
     *   eg: 2019-12-18 -> 2019-11-18
     */
    public static LocalDate getBeforeMonth(LocalDate date) {
        LocalDate lastMonth = getStartOfBeforeMonth(date);

        int lengthOfMonth = date.lengthOfMonth();
        int lengthOfBeforeMonth = lastMonth.lengthOfMonth();

        int day = date.getDayOfMonth();

        if(day == lengthOfMonth || day >=  lengthOfBeforeMonth) {
            // 指定月最后一天 或 大于上一月总天数
            lastMonth = lastMonth.withDayOfMonth(lengthOfBeforeMonth);
        } else {
            lastMonth = lastMonth.withDayOfMonth(day);
        }

        return lastMonth;
    }
    
    public static void main(String[] args) {
        System.out.println(getStartOfBeforeWeek(LocalDate.parse("2019-11-29")));
        System.out.println(getStartOfBeforeWeek(LocalDate.parse("2019-11-30")));
        System.out.println(getStartOfBeforeWeek(LocalDate.parse("2020-01-01")));
        System.out.println(getBeforeWeek(LocalDate.parse("2020-01-02")));
        System.out.println(getBeforeWeek(LocalDate.parse("2020-01-30")));
        System.out.println(getBeforeWeek(LocalDate.parse("2020-01-31")));
    }

}
