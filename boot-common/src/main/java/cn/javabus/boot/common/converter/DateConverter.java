package cn.javabus.boot.common.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateConverter.class);
    SimpleDateFormat dateFormat_nomal = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat dateFormat_long = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat dateFormat_short = new SimpleDateFormat("yyyy-MM");

    @Override
    public Date convert(String source) {
        if (!StringUtils.isEmpty(source)) {
            try {
                try {
                    return new Date(new Long(source));
                } catch (Exception e) {
                }
                SimpleDateFormat dateFormat = dateFormat_nomal;
                int len = source.length();
                if (len > 10) {
                    dateFormat = dateFormat_long;
                } else if (len < 10) {
                    dateFormat = dateFormat_short;
                }
                dateFormat.setLenient(false);
                return dateFormat.parse(source);
            } catch (ParseException e) {
                LOGGER.error("日期格式转换失败!" + source, e);
            }
        }
        return null;
    }
}
