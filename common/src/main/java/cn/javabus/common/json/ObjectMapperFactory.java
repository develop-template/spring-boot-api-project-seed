package cn.javabus.common.json;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.Serializable;

/**
 * @author wangkaihui
 * @date 2018/12/4
 */
public class ObjectMapperFactory implements Serializable {

    public static ObjectMapper create() {
        ObjectMapper objectMapper = new ObjectMapper();
        return create(objectMapper);
    }

    public static ObjectMapper create(ObjectMapper objectMapper) {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // BigDecimal 统一返回两位小数
        SimpleModule module = new SimpleModule();
        module.addSerializer(new BigDecimalSerializer());
        objectMapper.registerModule(module);
        return objectMapper;
    }

}
