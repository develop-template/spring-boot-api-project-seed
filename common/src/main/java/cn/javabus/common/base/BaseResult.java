package cn.huacloud.tax.common.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wangkaihui
 * @date 2018/10/25
 */
@Data
public class BaseResult implements Serializable {
    public interface BaseStatusConst {
        int REQUEST_SUCCESS = 0;

        int REQUEST_Ok = 200;

        int SERVER_ERROR = 501;
    }

    /**
     * 状态码: 0成功, 其他为失败
     */
    public int code;

    /**
     * 消息
     */
    public String msg;

    /**
     * 数据结果集
     */
    public Object data;

    /**
     * 错误异常
     */
    public Object error;

    /**
     * jwt的token信息
     */
    public String token;

    public BaseResult() {
    }

    public BaseResult(Object data) {
        this.code = 200;
        this.data = data;
    }

    public BaseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResult(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseResult(int code, String msg, Object data, Object error) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.error = error;
    }
}
