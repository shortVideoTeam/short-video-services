package com.huomai.business.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 推广记录对象 huomai_user_promote
 *
 * @author huomai
 * @date 2021-07-06
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("huomai_user_promote")
public class HuomaiUserPromote implements Serializable {

  private static final long serialVersionUID = 1L;

  /** ID */
  @TableId(value = "id")
  private Long id;

  /** 用户ID */
  private Long userId;

  /** 视频ID */
  private Long videoId;

  /** 推广时间 */
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;

  /** 推广状态( 1: 已报名 2: 已参与 3:已失效 ) */
  private String status;

  /** 热门次数 */
  private Long hotNum;

  /** 推广收益 */
  private BigDecimal profit;

  /** 发出推广值 */
  private BigDecimal sendVal;

  /** 收到推广值 */
  private BigDecimal receivedVal;
}
