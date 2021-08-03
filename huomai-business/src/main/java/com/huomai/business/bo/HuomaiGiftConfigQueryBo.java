package com.huomai.business.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

import java.math.BigDecimal;
import com.huomai.common.core.domain.BaseEntity;

/**
 * 红包金额配置分页查询对象 huomai_gift_config
 *
 * @author huomai
 * @date 2021-07-18
 */
        
    @Data
    @EqualsAndHashCode(callSuper = true)
    @ApiModel("红包金额配置分页查询对象")
    public class HuomaiGiftConfigQueryBo extends BaseEntity {

    /** 分页大小 */
    @ApiModelProperty("分页大小")
    private Integer pageSize;
    /** 当前页数 */
    @ApiModelProperty("当前页数")
    private Integer pageNum;
    /** 排序列 */
    @ApiModelProperty("排序列")
    private String orderByColumn;
    /** 排序的方向desc或者asc */
    @ApiModelProperty(value = "排序的方向", example = "asc,desc")
    private String isAsc;


                                    /** 总金额 */
                    @ApiModelProperty("总金额")
        private BigDecimal totalAmount;
                                /** 单笔领取金额 */
                    @ApiModelProperty("单笔领取金额")
        private BigDecimal singleAmount;
            
}
