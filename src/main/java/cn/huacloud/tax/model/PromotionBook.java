package cn.huacloud.tax.model;

import javax.persistence.*;

@Table(name = "promotion_book")
public class PromotionBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 活动id
     */
    @Column(name = "promotion_id")
    private Long promotionId;

    /**
     * 店铺id
     */
    @Column(name = "store_id")
    private Long storeId;

    /**
     * 微信号
     */
    private String wechat;

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
     * 获取店铺id
     *
     * @return store_id - 店铺id
     */
    public Long getStoreId() {
        return storeId;
    }

    /**
     * 设置店铺id
     *
     * @param storeId 店铺id
     */
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    /**
     * 获取微信号
     *
     * @return wechat - 微信号
     */
    public String getWechat() {
        return wechat;
    }

    /**
     * 设置微信号
     *
     * @param wechat 微信号
     */
    public void setWechat(String wechat) {
        this.wechat = wechat;
    }
}