package com.huomai.business.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 推广配置对象 huomai_promote_config
 *
 * @author huomai
 * @date 2021-07-05
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("huomai_promote_config")
public class HuomaiPromoteConfig implements Serializable {

  private static final long serialVersionUID = 1L;

  /** id */
  @TableId(value = "id")
  private Long id;

  /** 邀请人数 */
  private Long inviteNum;

  /** 推广金额 */
  private BigDecimal money;

  /** 推广平台比例 */
  private BigDecimal platformRate;

  /** 邀请人比例 */
  private BigDecimal inviteRate;

  /** 被助推人比例 */
  private BigDecimal boosterRate;

  /** 热门人数限定 */
  private Long maxNum;
}
