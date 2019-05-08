package cn.javabus.article.constants;

/**
 * @author ouzhx on 2019/1/23.
 */
public interface AriticleMQConstants {
    String exchange = "topicExchange";

    /**
     * 资讯批量同步消息
     **/
    String route_key_insertList = "search.article.insertList";
    /**
     * 资讯下架消息
     **/
    String route_key_delete = "search.article.delete";
    /**
     * 资讯发布消息
     **/
    String route_key_insert = "search.article.insert";
}
