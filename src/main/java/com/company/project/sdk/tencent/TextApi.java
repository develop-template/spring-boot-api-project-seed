package com.company.project.sdk.tencent;

import java.util.TreeMap;

import com.javastar920905.util.StringUtil;
import org.apache.commons.lang3.StringUtils;

/**
 * @author ouzhx on 2018/5/16.
 *         <p>
 *         文本分析api: http://ai.qq.com/doc/nlpbase.shtml
 */
public class TextApi implements ApiConstants {


  /**
   * 对文本进行智能分词识别(gbk编码) (接口对接通过,存在乱码问题!)
   * <p>
   * http://ai.qq.com/doc/nlpbase.shtml
   *
   * @return
   */
  public String wordSegmentation(String text) {
    if (StringUtils.isEmpty(text)) {
      return "文本不能为空";
    }
    TreeMap<String, String> treeMap = buildParamMap(App.AiJava);
    treeMap.put(key_text, text);
    treeMap.put(key_sign, getReqSign(App.AiJava, treeMap));
    // return HttpUtil.doPost("https://api.ai.qq.com/fcgi-bin/nlp/nlp_wordseg", treeMap);
    return doPost("https://api.ai.qq.com/fcgi-bin/nlp/nlp_wordseg", treeMap);
  }

  /**
   * 语义分析接口(utf-8编码)
   * <p>
   * 接口文档: http://ai.qq.com/doc/nlpsem.shtml
   *
   * @param text
   * @return
   */
  public String wordAnalysis(String text) {
    if (StringUtils.isEmpty(text)) {
      return "文本不能为空";
    }
    TreeMap<String, String> treeMap = buildParamMap(App.AiJava);
    treeMap.put(key_text, text);
    treeMap.put(key_sign, getReqSign(App.AiJava, treeMap));
    return doPost("https://api.ai.qq.com/fcgi-bin/nlp/nlp_wordcom", treeMap);
  }

  /**
   * 情感分析接口(utf-8编码)
   * <p>
   * 接口文档: http://ai.qq.com/doc/nlpemo.shtml
   * 
   * 情感编码定义 情感编码 情感描述 -1 负面 0 中性 1 正面
   *
   * @param text
   * @return {"polar":0,"confd":1,"text":"你给我走开"}
   */
  public String wordEmotionAnalysis(String text) {
    if (StringUtils.isEmpty(text)) {
      return "文本不能为空";
    }
    TreeMap<String, String> treeMap = buildParamMap(App.AiJava);
    treeMap.put(key_text, text);
    treeMap.put(key_sign, getReqSign(App.AiJava, treeMap));
    return doPost("https://api.ai.qq.com/fcgi-bin/nlp/nlp_textpolar", treeMap);
  }


  /**
   * 智能闲聊接口(可以自定义-闲聊画像设置)
   * 
   * http://ai.qq.com/doc/nlpchat.shtml
   * 
   * @param text
   * @return {"answer":"哈哈，秘密，不告诉你。","session":"ouzhx_chat_session_id_1"}
   */
  public String wordchat(String text) {
    if (StringUtils.isEmpty(text)) {
      return "文本不能为空";
    }
    TreeMap<String, String> treeMap = buildParamMap(App.AiJava);
    treeMap.put("question", text);
    treeMap.put("session", "ouzhx_chat_session_id_1");
    treeMap.put(key_sign, getReqSign(App.AiJava, treeMap));
    return doPost("https://api.ai.qq.com/fcgi-bin/nlp/nlp_textchat", treeMap);
  }


  /**
   * 
   *
   * @param text
   * @return {"answer":"哈哈，秘密，不告诉你。","session":"ouzhx_chat_session_id_1"}
   */

  /**
   * 文本翻译
   *
   * http://ai.qq.com/doc/nlptrans.shtml
   * 
   * @param text
   * @param type {0:自动识别（中英文互转）, 1: 中文翻译成英文, 其他:参考文档}
   * @return
   */
  public String wordTranslation(String text, String type) {
    if (StringUtils.isEmpty(text)) {
      return "文本不能为空";
    }
    TreeMap<String, String> treeMap = buildParamMap(App.AiJava);
    treeMap.put(key_text, text);
    treeMap.put("type", type);
    treeMap.put(key_sign, getReqSign(App.AiJava, treeMap));
    return doPost("https://api.ai.qq.com/fcgi-bin/nlp/nlp_texttrans", treeMap);
  }

  /**
   * 图片翻译(图片大小不能超过1M)(每次识别都没有结果...)
   *
   * http://ai.qq.com/doc/imagetranslate.shtml
   *
   * @param imageBase64
   * @param scene {word:单词识别，doc:文档识别}
   * @param source (源语言缩写:中文,英文) {zh:中文，en:英文,jp:日本,kr:韩文,auto:中英文自动识别}
   * @param target (目标语言缩写:同上source) {zh:中文，en:英文...}
   * @return {"image_records":[],"session_id":"1b94f213ab8c4353aa1232b1fecf2e4b"}
   */
  public String image2WordTranslation(String imageBase64, String scene, String source, String target) {
    if (StringUtils.isEmpty(imageBase64)) {
      return "文本不能为空";
    }
    TreeMap<String, String> treeMap = buildParamMap(App.AiJava);
    // 原始图片的base64编码数据（原图大小上限1MB）
    treeMap.put("image", imageBase64);
    treeMap.put("session_id", StringUtil.getUUId());
    treeMap.put("scene", scene);
    treeMap.put("source", source);
    treeMap.put("target", target);
    treeMap.put(key_sign, getReqSign(App.AiJava, treeMap));
    return doPost("https://api.ai.qq.com/fcgi-bin/nlp/nlp_imagetranslate", treeMap);
  }

}
