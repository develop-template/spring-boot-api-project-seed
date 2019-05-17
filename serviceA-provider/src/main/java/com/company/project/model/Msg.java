package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
/**
 @author ouzhx on 2019/05/17 
 */
@Setter
@Getter
public class Msg {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  /**
   * 业务类型
   */
  private Integer mType;
  /**
   * 业务id
   */
  private Long ywid;
  private Date createTime;
  /**
   * 是否已读,0:未读
   */
  private Byte readed;
  /**
   * 是否删除,0:未删除
   */
  private Byte deleted;
  /**
   * 优先级:0:一般,1:重要
   */
  private Byte priority;
  /**
   * 消息分类(0::服务消息,1系统消息:2 订阅消息)
   */
  private Byte category;
  /**
   * 接收消息用户id
   */
  private Long userId;
  /**
   * 消息内容
   */
  private String content;
  /**
   * 需求还是订单消息  取值参考 MsgConstants.MsgPage
   */
  private Byte mPage;
  /**
   * 业务编号
   */
  private String ywNo;
  /**
   * 自定义消息简要描述
   */
  private String shortDesc;
  /**
   * 消息被多少用户查看
   */
  private Long readCount;
  /**
   * 消息推送给了多少用户
   */
  private Long pushCount;
  private String title;
  /**
   * 推送消息给多用户,隔开(10w用户可推100个人)
   */
  private String pushTo;
  /**
   * 推送方式 {手动推送:manual,定时推送:timing}
   */
  private String pushWay;
  /**
   * 定时推送时间
   */
  private Date pushTime;
  /**
   * 是否推送过{10:已推送,20:未推送}
   */
  private Byte pushStatus;
  /**
   * @return id
   */
} 