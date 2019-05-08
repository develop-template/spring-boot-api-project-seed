package cn.javabus.common.util;

import java.io.Serializable;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wangkaihui
 * @date 2018/10/29
 */
public class StringUtils implements Serializable {
    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String mockMobilePhone(String mobilePhone) {
        if (isEmpty(mobilePhone)) {
            return mobilePhone;
        }
        char[] chars = mobilePhone.toCharArray();
        int length = chars.length;
        if (length > 3) {
            for (int index = 3; index < length && index < 7; index++) {
                chars[index] = '*';
            }
        }
        return new String(chars);
    }

    public static String replaceSpecialCode(String str) {
        if (isEmpty(str)){
            return str;
        }
        return str.replace("%", "\\%")
                .replace("_", "\\_").replace("\\", "\\\\").replace("*", "\\*")
                .replace("+", "\\+").replace("|", "\\|")
                .replace("{", "\\{").replace("}", "\\}")
                .replace("(", "\\(").replace(")", "\\)")
                .replace("^", "\\^").replace("$", "\\$")
                .replace("[", "\\[").replace("]", "\\]")
                .replace("?", "\\?").replace(",", "\\,")
                .replace(".", "\\.").replace("&", "\\&");
    }

    public static String getUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 判断指定参数是否有空值
     * @param args
     * @return
     */
    public static boolean hasEmpty(Object... args) {
        boolean flag = false;
        for (Object o : args) {
            if (o == null) {
                flag = true;
            }
            if (o instanceof String && "".equals(o)) {
                return true;
            }
        }
        return flag;
    }



    /**
     * 去除html标签
     * @param htmlStr
     * @return
     */
    public static String delHTMLTag(String htmlStr){
        String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式
        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式
        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式

        Pattern p_script= Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE);
        Matcher m_script=p_script.matcher(htmlStr);
        htmlStr=m_script.replaceAll(""); //过滤script标签

        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);
        Matcher m_style=p_style.matcher(htmlStr);
        htmlStr=m_style.replaceAll(""); //过滤style标签

        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
        Matcher m_html=p_html.matcher(htmlStr);
        htmlStr=m_html.replaceAll(""); //过滤html标签

        return htmlStr.trim(); //返回文本字符串
    }
}
