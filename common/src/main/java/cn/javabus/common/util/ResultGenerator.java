package cn.huacloud.tax.common.util;

import com.alibaba.fastjson.JSONObject;


/**
 * @author ouzhx on 2018/7/31.
 */
public class ResultGenerator {
    public static final String MSG = "msg";
    public static final String DATA = "data";
    public static final String CODE = "code";

    /*参考 org.springframework.http.HttpStatus*/
    public enum HttpCode {
        SUCCESS(200), FAIL(500),NOT_PAY(50001), REPEAT_REQ(400);
        public int code;

        HttpCode(int code) {
            this.code = code;
        }
    }

    public static JSONObject genSuccessResult(Object data) {
        JSONObject resultJson = new JSONObject();
        resultJson.put(CODE, HttpCode.SUCCESS.code);
        resultJson.put(DATA, data);
        resultJson.put(MSG, "请求成功!");
        return resultJson;
    }

    public static JSONObject genSuccessResult(String msg) {
        JSONObject resultJson = new JSONObject();
        resultJson.put(CODE, HttpCode.SUCCESS.code);
        resultJson.put(MSG, msg);
        resultJson.put(DATA, null);
        return resultJson;
    }

    public static JSONObject genFailResult(String msg) {
        /*JSONObject resultJson = new JSONObject();
        resultJson.put(CODE, HttpCode.FAIL.code);
        resultJson.put(MSG, msg);
        resultJson.put(DATA, null);
        return resultJson;*/
        throw new RuntimeException(msg);
    }

    public static JSONObject genRepeatResult(String msg) {
        /*JSONObject resultJson = new JSONObject();
        resultJson.put(CODE, HttpCode.REPEAT_REQ.code);
        resultJson.put(MSG, msg);
         return resultJson;*/
        throw new RuntimeException(msg);
    }

    public static JSONObject genResult(int result) {
        JSONObject resultJson = new JSONObject();
        if (result > 0) {
            resultJson.put(CODE, HttpCode.SUCCESS.code);
            resultJson.put(MSG, "操作成功!");
        } else {
           /* resultJson.put(CODE, HttpCode.FAIL.code);
            resultJson.put(MSG, "操作失败!");*/
            throw new RuntimeException("操作结果:"+result);
        }
        resultJson.put(DATA, result);
        return resultJson;
    }
}
