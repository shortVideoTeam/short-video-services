package com.huomai.business.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.huomai.common.annotation.Excel;

/**
 * 红包金额配置对象 huomai_gift_config
 *
 * @author huomai
 * @date 2021-07-18
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("huomai_gift_config")
public class HuomaiGiftConfig implements Serializable{

private static final long serialVersionUID=1L;


/** ID */
                        @TableId(value = "id")
    private Long id;

/** 总金额 */
                    private BigDecimal totalAmount;

/** 单笔领取金额 */
                    private BigDecimal singleAmount;

}
