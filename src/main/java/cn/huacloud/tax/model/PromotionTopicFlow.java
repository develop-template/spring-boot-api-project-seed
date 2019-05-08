package cn.huacloud.tax.model;

import javax.persistence.*;

@Table(name = "promotion_topic_flow")
public class PromotionTopicFlow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 专题id
     */
    @Column(name = "promotion_topic_id")
    private Long promotionTopicId;

    /**
     * 流程名称
     */
    @Column(name = "flow_name")
    private String flowName;

    /**
     * 流程描述
     */
    @Column(name = "flow_desc")
    private String flowDesc;

    /**
     * 流程排序
     */
    private Byte order;

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
     * 获取专题id
     *
     * @return promotion_topic_id - 专题id
     */
    public Long getPromotionTopicId() {
        return promotionTopicId;
    }

    /**
     * 设置专题id
     *
     * @param promotionTopicId 专题id
     */
    public void setPromotionTopicId(Long promotionTopicId) {
        this.promotionTopicId = promotionTopicId;
    }

    /**
     * 获取流程名称
     *
     * @return flow_name - 流程名称
     */
    public String getFlowName() {
        return flowName;
    }

    /**
     * 设置流程名称
     *
     * @param flowName 流程名称
     */
    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }

    /**
     * 获取流程描述
     *
     * @return flow_desc - 流程描述
     */
    public String getFlowDesc() {
        return flowDesc;
    }

    /**
     * 设置流程描述
     *
     * @param flowDesc 流程描述
     */
    public void setFlowDesc(String flowDesc) {
        this.flowDesc = flowDesc;
    }

    /**
     * 获取流程排序
     *
     * @return order - 流程排序
     */
    public Byte getOrder() {
        return order;
    }

    /**
     * 设置流程排序
     *
     * @param order 流程排序
     */
    public void setOrder(Byte order) {
        this.order = order;
    }
}