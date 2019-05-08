package cn.javabus.article.service;



/**
 * @author ouzhx on 2018/12/05.
 * 爬虫库service
 */
public interface SpiderArticleService {


    /**
     * 发起调度 绑定政策和解读
     */
    void ArticleRelatedSchedule();

    /**
     * 同步爬虫库到业务库
     */
    void articleSynchronize();

    /**
     * 检查并及时业务库信息
     */
    void articleUpdateSynchronize();

    /**
     * 同步业务库到es
     */
    void articleSychronizeToEs();

}
