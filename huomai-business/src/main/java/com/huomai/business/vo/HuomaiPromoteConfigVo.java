package com.huomai.business.vo;

import com.huomai.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 推广配置视图对象 huomai_promote_config
 *
 * @author huomai
 * @date 2021-07-05
 */
@Data
@ApiModel("推广配置视图对象")
public class HuomaiPromoteConfigVo {

  private static final long serialVersionUID = 1L;

  /** id */
  @ApiModelProperty("id")
  private Long id;

  /** 邀请人数 */
  @Excel(name = "邀请人数")
  @ApiModelProperty("邀请人数")
  private Long inviteNum;

  /** 推广金额 */
  @Excel(name = "推广金额")
  @ApiModelProperty("推广金额")
  private BigDecimal money;

  /** 推广平台比例 */
  @Excel(name = "推广平台比例")
  @ApiModelProperty("推广平台比例")
  private BigDecimal platformRate;

  /** 邀请人比例 */
  @Excel(name = "邀请人比例")
  @ApiModelProperty("邀请人比例")
  private BigDecimal inviteRate;

  /** 被助推人比例 */
  @Excel(name = "被助推人比例")
  @ApiModelProperty("被助推人比例")
  private BigDecimal boosterRate;

  /** 热门人数限定 */
  @Excel(name = "热门人数限定")
  @ApiModelProperty("热门人数限定")
  private Long maxNum;
}
