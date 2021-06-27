package com.huomai.business.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * huomai_recharge_rule
 * @author 
 */
@Data
public class HuomaiRechargeRule implements Serializable {
    /**
     * ID
     */
    private Long id;

    /**
     * 金额
     */
    private BigDecimal amount;

    private static final long serialVersionUID = 1L;
}