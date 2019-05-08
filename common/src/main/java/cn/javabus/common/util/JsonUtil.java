package cn.javabus.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author ouzhx on 2018/8/20.
 */
public class JsonUtil {
    private JsonUtil() {
    }

    public static JSONObject parse2JsonWithDateFormat(Object obj) {
        return JSON.parseObject(JSON.toJSONStringWithDateFormat(obj, "yyyy-MM-dd hh:mm:ss", SerializerFeature.WriteMapNullValue));
    }

    public static JSONObject parse2Json(Object obj) {
        return JSON.parseObject(JSON.toJSONString(obj, SerializerFeature.WriteMapNullValue));
    }

    public static String toJsonString(Object obj){
        return JSON.toJSONString(obj, SerializerFeature.WriteMapNullValue);
    }

}
