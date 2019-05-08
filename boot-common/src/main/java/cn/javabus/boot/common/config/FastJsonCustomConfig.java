package cn.javabus.boot.common.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.Charset;

/**
 * @author ouzhx on 2018/8/31.
 */
@Configuration
public class FastJsonCustomConfig {

    @Bean
    public FastJsonConfig config() {
        FastJsonConfig config = new FastJsonConfig();
        config.setCharset(Charset.forName("utf-8"));
        config.setDateFormat("yyyy-MM-dd HH:mm:ss");
        config.setSerializerFeatures(SerializerFeature.WriteMapNullValue,SerializerFeature.DisableCircularReferenceDetect);
        return config;
    }

}
