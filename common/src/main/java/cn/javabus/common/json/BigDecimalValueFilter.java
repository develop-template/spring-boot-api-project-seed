package cn.javabus.common.json;

import com.alibaba.fastjson.serializer.ValueFilter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @date 2018/12/4
 */
public class BigDecimalValueFilter implements ValueFilter {

    private DecimalFormat decimalFormat = new DecimalFormat("0.00");

    @Override
    public Object process(Object object, String name, Object value) {
        if (value != null && value instanceof BigDecimal) {
            return new BigDecimal(decimalFormat.format(value));
        }
        return value;
    }
}
