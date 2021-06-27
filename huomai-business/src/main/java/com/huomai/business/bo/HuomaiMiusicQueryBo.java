package com.huomai.business.bo;

import com.huomai.common.core.domain.BaseEntity;
import com.huomai.common.core.domain.PageBo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 音乐模板分页查询对象 huomai_miusic
 *
 * @author huomai
 * @date 2021-06-19
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("音乐模板分页查询对象")
public class HuomaiMiusicQueryBo extends PageBo {

}
