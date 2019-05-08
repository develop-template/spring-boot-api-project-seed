package cn.huacloud.tax.model;

import javax.persistence.*;

@Table(name = "promotion_topic_book")
public class PromotionTopicBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 活动id
     */
    @Column(name = "promotion_id")
    private Long promotionId;

    /**
     * 专题id
     */
    @Column(name = "promotion_topic_id")
    private Long promotionTopicId;

    /**
     * 专题类型
     */
    @Column(name = "promotion_topic_type")
    private String promotionTopicType;

    /**
     * 活动报名状态{10:审核中,20:报名失败,30:审核通过}
     */
    @Column(name = "book_status")
    private Byte bookStatus;

    /**
     * 产品id
     */
    @Column(name = "product_id")
    private Long productId;

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
     * 获取专题类型
     *
     * @return promotion_topic_type - 专题类型
     */
    public String getPromotionTopicType() {
        return promotionTopicType;
    }

    /**
     * 设置专题类型
     *
     * @param promotionTopicType 专题类型
     */
    public void setPromotionTopicType(String promotionTopicType) {
        this.promotionTopicType = promotionTopicType;
    }

    /**
     * 获取活动报名状态{10:审核中,20:报名失败,30:审核通过}
     *
     * @return book_status - 活动报名状态{10:审核中,20:报名失败,30:审核通过}
     */
    public Byte getBookStatus() {
        return bookStatus;
    }

    /**
     * 设置活动报名状态{10:审核中,20:报名失败,30:审核通过}
     *
     * @param bookStatus 活动报名状态{10:审核中,20:报名失败,30:审核通过}
     */
    public void setBookStatus(Byte bookStatus) {
        this.bookStatus = bookStatus;
    }

    /**
     * 获取产品id
     *
     * @return product_id - 产品id
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * 设置产品id
     *
     * @param productId 产品id
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }
}