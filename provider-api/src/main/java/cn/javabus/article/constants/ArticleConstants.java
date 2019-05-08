package cn.javabus.article.constants;

import lombok.AllArgsConstructor;

import java.io.Serializable;

/**
 * @author ouzhx on 2018/12/6.
 */
public interface ArticleConstants {

    String platform = "javabus";
    int content_limit = 300;

//    @AllArgsConstructor
//    enum Publish {
//        y(10), n(20);
//        public int value;
//
//        final static String str = Publish.y.value + "";
//
//        public static boolean isPublish(String val) {
//            return str.equals(val);
//        }
//
//    }
//
//
//    @AllArgsConstructor
//    enum Tag implements Serializable {
//        interpretation("解"), hot("热"), newly("新");
//        public String tagName;
//    }

}
