package com.huomai.business.bo;

import com.huomai.common.core.domain.PageBo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 搜索历史记录分页查询对象 huomai_user_seach_his
 *
 * @author huomai
 * @date 2021-06-19
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("搜索历史记录分页查询对象")
public class HuomaiUserSeachHisQueryBo extends PageBo {

}
