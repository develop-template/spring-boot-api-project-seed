package cn.javabus.common.util;

import javax.servlet.http.HttpServletRequest;

/**
 *
 */
public class IpUtil {


    private static final String DEFAULT_IP="58.61.30.29";


    public static String getRemoteAddr(HttpServletRequest request){
        String Xip = request.getHeader("X-Real-IP");
        String XFor = request.getHeader("X-Forwarded-For");
        if(null!=XFor && !"unKnown".equalsIgnoreCase(XFor)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = XFor.indexOf(",");
            if(index != -1){
                return XFor.substring(0,index);
            }else{
                return XFor;
            }
        }
        XFor = Xip;
        if(null!=XFor && !"unKnown".equalsIgnoreCase(XFor)){
            return XFor;
        }
        if ("".equals(XFor)||null==XFor  || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("Proxy-Client-IP");
        }
        if ("".equals(XFor) ||null==XFor  || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("WL-Proxy-Client-IP");
        }
        if ("".equals(XFor)||null==XFor   || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_CLIENT_IP");
        }
        if ("".equals(XFor)||null==XFor  || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if ("".equals(XFor)||null==XFor   || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getRemoteAddr();
        }
        if( XFor.equals("0:0:0:0:0:0:0:1")){
            XFor=DEFAULT_IP;
        }

        return XFor;
    }

}
