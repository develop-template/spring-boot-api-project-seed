package cn.javabus.common.util;

import cn.hutool.http.HttpUtil;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.util.TreeMap;


/**
 * @author ouzhx on 2019/2/22.
 * 调用赛邮api  参考文档: https://www.mysubmail.com/chs/documents/developer/yR0Ov
 * (注意每天只能免费发送 200个邮件)
 */
public class SubmailAPI {
    private static final String URL = "https://api.mysubmail.com/mail/send.json";

    public static void sendMail(SubMailParam subMailParam) {

        TreeMap<String, Object> requestData = new TreeMap<>();
        requestData.put("appid", subMailParam.appid);
        requestData.put("from", subMailParam.from);
        requestData.put("to", subMailParam.to);
        requestData.put("subject", subMailParam.subject);
        requestData.put("html", subMailParam.html);
        requestData.put("attachments", subMailParam.attachments);
        requestData.put("signature", subMailParam.signature);


        String r = HttpUtil.post(URL, requestData);
        System.out.println(r);
    }


    @Data
    public static class SubMailParam {
        private final String appid = "14118";
        private String to;
        private final String from = "ouzx@javabus.cn";
        private String subject;
        //html格式邮件正文
        private String html;
        //回复地址
        private String reply;
        private File attachments;
        //应用密匙 或 数字签名
        private final String signature = "d1971fee18499785019f9bdb4294ae49";

    }
}
