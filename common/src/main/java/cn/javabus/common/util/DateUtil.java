package cn.javabus.common.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 */
public class DateUtil {

    public static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat format_with_hour = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat format_yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss");

    private static final int ONE = 1;
    private static final int ZERO = 0;
    private static final int SIX = 6;
    private static final int TEN = 10;

    /**
     * 得到以当前时间为准的Calendar实例
     *
     * @return Calendar instance
     */
    public static Calendar getCurrentTimeCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return calendar;
    }

    /**
     * 得到当前时间戳字符串
     *
     * @return 时间戳字符串 如:201812061201295842eb
     */
    public static String getCurrentTimestampStr() {
        Calendar calendar = getCurrentTimeCalendar();
        StringBuilder sb = new StringBuilder();
        sb.append(calendar.get(Calendar.YEAR));
        sb.append(addZeroPrefix(calendar.get(Calendar.MONTH) + ONE));
        sb.append(addZeroPrefix(calendar.get(Calendar.DATE)));
        sb.append(addZeroPrefix(calendar.get(Calendar.HOUR_OF_DAY)));
        sb.append(addZeroPrefix(calendar.get(Calendar.MINUTE)));
        sb.append(addZeroPrefix(calendar.get(Calendar.SECOND)));
        sb.append(UUID.randomUUID().toString().substring(ZERO, SIX));
        return sb.toString();
    }

    /**
     * 当value大于0小于10的时候为数字添加前缀0
     *
     * @param value 数值
     * @return 添加前缀0后的字符串
     */
    public static String addZeroPrefix(Integer value) {
        StringBuilder sb = new StringBuilder();
        if (value < TEN) {
            sb.append(ZERO);
        }
        sb.append(value);
        return sb.toString();
    }

    public static Date localDateTime2date(LocalDateTime localDateTime) {
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }

    public static LocalDate date2LocalDate(Date date) {
        if (date == null) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static Date localDate2Date(LocalDate localDate) {
        ZonedDateTime zonedDateTime = localDate.atStartOfDay().atZone(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }

    public static long getDaysBetween(Date begin, Date end) {
        return (end.getTime() - begin.getTime() + 1000000) / (60 * 60 * 24 * 1000);
    }
}
