package com.company.project.sdk.tencent;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author ouzhx on 2018/5/18.
 * 
 *         image 和 base64 字符串转换工具
 */
public class Base64ImageUtil {
  private static BASE64Encoder encoder = new BASE64Encoder();
  private static BASE64Decoder decoder = new BASE64Decoder();

  public static String base64Encode(byte[] data) {
    // 对字节数组Base64编码,返回Base64编码过的字节数组字符串
    return encoder.encode(data);
  }

  /**
   * @Title: GetImageStrFromUrl
   * @Description: TODO(将一张网络图片转化成Base64字符串)
   * @param imgURL 网络资源位置
   * @return Base64字符串
   */
  public static String getStrFromUrl(String imgURL) {
    byte[] data = null;
    try {
      // 创建URL
      URL url = new URL(imgURL);
      // 创建链接
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      conn.setConnectTimeout(5 * 1000);
      InputStream inStream = conn.getInputStream();
      data = new byte[inStream.available()];
      inStream.read(data);
      inStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return base64Encode(data);
  }

  /**
   * @Title: GetImageStrFromPath
   * @Description: TODO(将一张本地图片转化成Base64字符串)
   * @param imgPath
   * @return
   */
  public static String getStrFromLocalPath(String imgPath) {
    InputStream in = null;
    byte[] data = null;
    // 读取图片字节数组
    try {
      in = new FileInputStream(imgPath);
      data = new byte[in.available()];
      in.read(data);
      in.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return base64Encode(data);
  }

  /**
   * @Title: GenerateImage
   * @Description: TODO(base64字符串转化成图片)
   * @param imgStr
   * @return
   */
  public static boolean GenerateImage(String imgStr) {
    if (imgStr == null) {
      return false;
    }

    try {
      // Base64解码
      byte[] b = decoder.decodeBuffer(imgStr);
      for (int i = 0; i < b.length; ++i) {
        if (b[i] < 0) {// 调整异常数据
          b[i] += 256;
        }
      }
      // 生成jpeg图片
      String imgFilePath = "d://Base64ToImage.jpg";
      OutputStream out = new FileOutputStream(imgFilePath);
      out.write(b);
      out.flush();
      out.close();
      return true;
    } catch (Exception e) {
      return false;
    }
  }

}
