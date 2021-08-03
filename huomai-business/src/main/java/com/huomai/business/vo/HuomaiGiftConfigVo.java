package com.huomai.business.vo;

import com.huomai.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
        import java.math.BigDecimal;
    import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


/**
 * 红包金额配置视图对象 huomai_gift_config
 *
 * @author huomai
 * @date 2021-07-18
 */
@Data
@ApiModel("红包金额配置视图对象")
public class HuomaiGiftConfigVo {

    private static final long serialVersionUID = 1L;

    /** ID */
    @ApiModelProperty("ID")
    private Long id;

                                    /** 总金额 */
                                                            @Excel(name = "总金额")
                    @ApiModelProperty("总金额")
        private BigDecimal totalAmount;

                                /** 单笔领取金额 */
                                                            @Excel(name = "单笔领取金额")
                    @ApiModelProperty("单笔领取金额")
        private BigDecimal singleAmount;

            
}
