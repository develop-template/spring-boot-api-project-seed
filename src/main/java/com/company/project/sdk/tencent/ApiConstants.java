package com.company.project.sdk.tencent;

import java.util.TreeMap;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author ouzhx on 2018/5/16.
 * 
 *         参考接入指南: http://ai.qq.com/doc/index.shtml
 */
public interface ApiConstants {
  /**
   * 应用标识（AppId）
   */
  String key_app_id = "app_id";
  /**
   * 请求时间戳（秒级）
   */
  String key_time_stamp = "time_stamp";
  /**
   * 随机字符串
   */
  String key_nonce_str = "nonce_str";
  /**
   * 签名信息，详见接口鉴权
   */
  String key_sign = "sign";
  /**
   * 待分析文本
   */
  String key_text = "text";

  static TreeMap<String, String> buildParamMap(App app) {
    TreeMap<String, String> treeMap = new TreeMap<>();
    treeMap.put(key_app_id, app.appID);
    treeMap.put(key_time_stamp, "");
    treeMap.put(key_nonce_str, "");
    return treeMap;
  }



  enum App {
    /**
     * (使用QQ 2111428948)登录控制台,获取相关信息 :
     * https://ai.qq.com/cgi-bin/console_usercenter#/app-management/app-list/
     */
    AiJava("1106910304", "TcRYEfbGPT04yXbB");
    private String appID;
    private String appKey;

    App(String appID, String appKey) {
      this.appID = appID;
      this.appKey = appKey;
    }

    /**
     * 计算签名方法 调用平台AI技术接口之前，首先需要获取接口鉴权签名 http://ai.qq.com/doc/auth.shtml
     *
     * 注意: 签名有效期5分钟，需要请求接口时刻实时计算签名信息
     */
    public static String getReqSign(TreeMap<String, String> paramMap) {
      if (paramMap == null || paramMap.isEmpty()) {
        return "请求参数不能为空!";
      }

      // 1 将<key, value>请求参数对按key进行字典升序排序，得到有序的参数对列表N --(参数使用TreeMap 自动维护顺序)

      // 将列表N中的参数对按URL键值对的格式拼接成字符串，得到字符串T（如：key1=value1&key2=value2），URL键值拼接过程value部分需要URL编码，URL编码算法用大写字母，例如%E8，而不是小写%e8
      StringBuilder str = new StringBuilder();
      for (String key : paramMap.keySet()) {
        str.append(key).append("=").append(paramMap.get(key)).append("&");
      }
      // str.deleteCharAt(str.length()-1); //删除最后一个&; 下面刚好要用& 不需要删除了

      // 3 将应用密钥以app_key为键名，组成URL键值拼接到字符串T末尾，得到字符串S（如：key1=value1&key2=value2&app_key=密钥)
      str.append("app_key=").append(App.AiJava.appKey);

      // 4 对字符串S进行MD5运算，将得到的MD5值所有字符转换成大写，得到接口请求签名
      return DigestUtils.md5Hex(str.toString()).toUpperCase();
    }
  }


}
