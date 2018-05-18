package com.conpany.project.sdk;

import com.alibaba.fastjson.JSONObject;
import com.company.project.sdk.tencent.Base64ImageUtil;
import com.company.project.sdk.tencent.TextApi;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static com.company.project.sdk.tencent.Base64ImageUtil.getStrFromLocalPath;

/**
 * @author ouzhx on 2018/5/17.
 */
public class TextApiTest {
  TextApi textApi = new TextApi();

  @Test
  public void wordSegmenttationTest() {
    String resp = textApi.wordSegmentation("腾讯人工智能");
    JSONObject respJson = JSONObject.parseObject(resp);
    assert respJson.getString("msg").equals("ok");
    try {
      System.out.println(new String(respJson.getString("data").getBytes(), "utf-8"));
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void wordAnalysisTest() {

    String resp = textApi.wordAnalysis("今天深圳的天气怎么样？明天呢");
    JSONObject respJson = JSONObject.parseObject(resp);
    assert respJson.getString("msg").equals("ok");
    System.out.println(respJson.getString("data"));
  }

  @Test
  public void wordEmotionAnalysisTest() {
    String resp = textApi.wordEmotionAnalysis("你给我走开");
    JSONObject respJson = JSONObject.parseObject(resp);
    assert respJson.getString("msg").equals("ok");
    System.out.println(respJson.getString("data"));
  }

  @Test
  public void wordchatTest() {
    chatOnce("你好啊,你是谁");
    chatOnce("谁是世界上最帅的人");
  }

  private void chatOnce(String chatText) {
    String resp = textApi.wordchat(chatText);
    JSONObject respJson = JSONObject.parseObject(resp);
    assert respJson.getString("msg").equals("ok");
    System.out.println(respJson.getString("data"));
  }


  @Test
  public void wordTranslationTest() {
    String resp = textApi.wordTranslation("我爱你", "0");
    JSONObject respJson = JSONObject.parseObject(resp);
    assert respJson.getString("msg").equals("ok");
    System.out.println(respJson.getString("data"));
  }


  @Test
  public void image2WordTranslationTest() {
    // String imageBase64 = getStrFromLocalPath(
    // "D:\\gitrepository\\spring-boot-api-project-seed\\src\\main\\resources\\images\\disclaime.png");
    String imageBase64 =
        Base64ImageUtil.getStrFromUrl("http://randomdata.oss-cn-shenzhen.aliyuncs.com/timg.jpg");
    String resp = textApi.image2WordTranslation(imageBase64, "doc", "zh", "en");
    JSONObject respJson = JSONObject.parseObject(resp);
    assert respJson.getString("msg").equals("ok");
    System.out.println(respJson.getString("data"));
  }
}
