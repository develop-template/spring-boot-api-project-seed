package cn.javabus.common.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

/**
 * @author ouzhx on 2019/4/10.
 */
public class AliMailAPI {
//    public static void main(String[] args) {
//        MailParam mailParam = new MailParam();
//        mailParam.setTo("javastar920905@163.com");
//        mailParam.setSubject("阿里云邮件发送测试");
//        mailParam.setText("这是测试内容....good luck!");
//        sendMail(mailParam);
//    }

    public static void sendMail(MailParam mailParam) {
        // 如果是除杭州region外的其它region（如新加坡、澳洲Region），需要将下面的"cn-hangzhou"替换为"ap-southeast-1"、或"ap-southeast-2"。
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI5ZcQtsieoSRf", "oH9bfVsseGHsF95KeGlCYgrHoOqd8R");
        //使用https加密连接
        //profile.getHttpClientConfig().setProtocolType(com.aliyuncs.http.ProtocolType.HTTPS);
        // 如果是除杭州region外的其它region（如新加坡region）， 需要做如下处理
        //try {
        //DefaultProfile.addEndpoint("dm.ap-southeast-1.aliyuncs.com", "ap-southeast-1", "Dm",  "dm.ap-southeast-1.aliyuncs.com");
        //} catch (ClientException e) {
        //e.printStackTrace();
        //}
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendMailRequest request = new SingleSendMailRequest();
        try {
            //request.setVersion("2017-06-22");// 如果是除杭州region外的其它region（如新加坡region）,必须指定为2017-06-22
            request.setAccountName("ouzhx@ali.javabus.cn");
            request.setFromAlias(mailParam.getFromAlias());
            request.setAddressType(1);
            request.setTagName(mailParam.getTagName());
            request.setReplyToAddress(true);
            request.setToAddress(mailParam.getTo());
            //可以给多个收件人发送邮件，收件人之间用逗号分开，批量发信建议使用BatchSendMailRequest方式
            //request.setToAddress("邮箱1,邮箱2");
            request.setSubject(mailParam.getSubject());
            request.setHtmlBody(mailParam.getText());
            SingleSendMailResponse httpResponse = client.getAcsResponse(request);
            System.out.println("邮件发送结束" + httpResponse.getRequestId());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    @Data
    public static class MailParam {
        //可以给多个收件人发送邮件，收件人之间用逗号分开，
        private String to;
        private String subject;
        //html格式邮件正文
        private String text;

        //发件人昵称
        private String fromAlias = "ouzhx";
        //控制台创建的标签
        private String tagName = "javabus";
    }
}
