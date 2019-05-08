package cn.huacloud.tax.model;

import javax.persistence.*;

@Table(name = "promotion_action")
public class PromotionAction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 活动id
     */
    @Column(name = "promotion_id")
    private Long promotionId;

    /**
     * 活动开始动作,字典定为常量
     */
    private String action;

    /**
     * 活动描述
     */
    @Column(name = "action_desc")
    private String actionDesc;

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
     * 获取活动开始动作,字典定为常量
     *
     * @return action - 活动开始动作,字典定为常量
     */
    public String getAction() {
        return action;
    }

    /**
     * 设置活动开始动作,字典定为常量
     *
     * @param action 活动开始动作,字典定为常量
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * 获取活动描述
     *
     * @return action_desc - 活动描述
     */
    public String getActionDesc() {
        return actionDesc;
    }

    /**
     * 设置活动描述
     *
     * @param actionDesc 活动描述
     */
    public void setActionDesc(String actionDesc) {
        this.actionDesc = actionDesc;
    }
}