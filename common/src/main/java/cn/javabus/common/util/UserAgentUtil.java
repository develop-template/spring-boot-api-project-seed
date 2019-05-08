package cn.javabus.common.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * @author huangjie
 * @description 判断浏览器工具类
 * @date 2018/11/15
 */
public class UserAgentUtil {



    public static final String MICROMESSENGER="micromessenger";

    public static final String USER_AGENT="User-Agent";

    public static boolean isMobile(HttpServletRequest request) {
        List<String> mobileAgents = Arrays.asList("ipad", "iphone os", "rv:1.2.3.4", "ucweb", "android", "windows ce", "windows mobile");
        String ua = request.getHeader(USER_AGENT).toLowerCase();
        for (String sua : mobileAgents) {
            if (ua.indexOf(sua) > -1) {
                return true;//手机端
            }
        }
        return false;//PC端
    }

    /**
     * 是否微信浏览器
     * @param request
     * @return: boolean
     */
    public static boolean isWechat(HttpServletRequest request) {
        String ua = request.getHeader(USER_AGENT).toLowerCase();
        if (ua.indexOf(MICROMESSENGER) > -1) {
            return true;//微信
        }
        return false;//非微信小程序访问

    }


}
