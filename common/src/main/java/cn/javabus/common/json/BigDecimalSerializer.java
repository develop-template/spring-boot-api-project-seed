package cn.javabus.common.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author
 */
public class BigDecimalSerializer extends JsonSerializer<BigDecimal> {

    private DecimalFormat decimalFormat;

    public BigDecimalSerializer() {
        this("0.00");
    }

    public BigDecimalSerializer(String pattern) {
        this.decimalFormat = new DecimalFormat(pattern);
    }

    @Override
    public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeNumber(new BigDecimal(decimalFormat.format(value)));
    }

    @Override
    public Class<BigDecimal> handledType() {
        return BigDecimal.class;
    }
}
