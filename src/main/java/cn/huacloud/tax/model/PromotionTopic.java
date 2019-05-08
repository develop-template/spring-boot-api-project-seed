package cn.huacloud.tax.model;

import javax.persistence.*;

@Table(name = "promotion_topic")
public class PromotionTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 活动id
     */
    @Column(name = "promotion_id")
    private Long promotionId;

    /**
     * 活动专题
     */
    @Column(name = "topic_name")
    private String topicName;

    /**
     * 专题类型
     */
    @Column(name = "topic_type")
    private String topicType;

    /**
     * 专题描述
     */
    @Column(name = "topic_desc")
    private String topicDesc;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取活动id
     *
     * @return promotion_id - 活动id
     */
    public Long getPromotionId() {
        return promotionId;
    }

    /**
     * 设置活动id
     *
     * @param promotionId 活动id
     */
    public void setPromotionId(Long promotionId) {
        this.promotionId = promotionId;
    }

    /**
     * 获取活动专题
     *
     * @return topic_name - 活动专题
     */
    public String getTopicName() {
        return topicName;
    }

    /**
     * 设置活动专题
     *
     * @param topicName 活动专题
     */
    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    /**
     * 获取专题类型
     *
     * @return topic_type - 专题类型
     */
    public String getTopicType() {
        return topicType;
    }

    /**
     * 设置专题类型
     *
     * @param topicType 专题类型
     */
    public void setTopicType(String topicType) {
        this.topicType = topicType;
    }

    /**
     * 获取专题描述
     *
     * @return topic_desc - 专题描述
     */
    public String getTopicDesc() {
        return topicDesc;
    }

    /**
     * 设置专题描述
     *
     * @param topicDesc 专题描述
     */
    public void setTopicDesc(String topicDesc) {
        this.topicDesc = topicDesc;
    }
}