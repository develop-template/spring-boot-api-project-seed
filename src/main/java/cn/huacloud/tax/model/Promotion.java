package cn.huacloud.tax.model;

import java.util.Date;
import javax.persistence.*;

public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 活动名称
     */
    private String name;

    /**
     * 活动类型
     */
    private String type;

    /**
     * 活动最大人数
     */
    @Column(name = "max_people")
    private Integer maxPeople;

    /**
     * 活动开始时间
     */
    private Date begin;

    /**
     * 活动结束时间
     */
    private Date end;

    /**
     * {10:开始,20:进行中,30:结束}
     */
    @Column(name = "promotion_status")
    private Byte promotionStatus;

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
     * 获取活动名称
     *
     * @return name - 活动名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置活动名称
     *
     * @param name 活动名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取活动类型
     *
     * @return type - 活动类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置活动类型
     *
     * @param type 活动类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取活动最大人数
     *
     * @return max_people - 活动最大人数
     */
    public Integer getMaxPeople() {
        return maxPeople;
    }

    /**
     * 设置活动最大人数
     *
     * @param maxPeople 活动最大人数
     */
    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    /**
     * 获取活动开始时间
     *
     * @return begin - 活动开始时间
     */
    public Date getBegin() {
        return begin;
    }

    /**
     * 设置活动开始时间
     *
     * @param begin 活动开始时间
     */
    public void setBegin(Date begin) {
        this.begin = begin;
    }

    /**
     * 获取活动结束时间
     *
     * @return end - 活动结束时间
     */
    public Date getEnd() {
        return end;
    }

    /**
     * 设置活动结束时间
     *
     * @param end 活动结束时间
     */
    public void setEnd(Date end) {
        this.end = end;
    }

    /**
     * 获取{10:开始,20:进行中,30:结束}
     *
     * @return promotion_status - {10:开始,20:进行中,30:结束}
     */
    public Byte getPromotionStatus() {
        return promotionStatus;
    }

    /**
     * 设置{10:开始,20:进行中,30:结束}
     *
     * @param promotionStatus {10:开始,20:进行中,30:结束}
     */
    public void setPromotionStatus(Byte promotionStatus) {
        this.promotionStatus = promotionStatus;
    }
}