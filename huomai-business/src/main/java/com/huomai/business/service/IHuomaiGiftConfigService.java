package com.huomai.business.service;

import com.huomai.business.domain.HuomaiGiftConfig;
import com.huomai.business.vo.HuomaiGiftConfigVo;
import com.huomai.business.bo.HuomaiGiftConfigQueryBo;
import com.huomai.business.bo.HuomaiGiftConfigAddBo;
import com.huomai.business.bo.HuomaiGiftConfigEditBo;
import com.huomai.common.core.page.IServicePlus;
        import com.huomai.common.core.page.TableDataInfo;
    
import java.util.Collection;
import java.util.List;

/**
 * 红包金额配置Service接口
 *
 * @author huomai
 * @date 2021-07-18
 */
public interface IHuomaiGiftConfigService extends IServicePlus<HuomaiGiftConfig> {
    /**
     * 查询单个
     * @return
     */
        HuomaiGiftConfigVo queryById(Long id);

            /**
         * 查询列表
         */
        TableDataInfo<HuomaiGiftConfigVo> queryPageList(HuomaiGiftConfigQueryBo bo);
    
    /**
     * 查询列表
     */
    List<HuomaiGiftConfigVo> queryList(HuomaiGiftConfigQueryBo bo);

    /**
     * 根据新增业务对象插入红包金额配置
     * @param bo 红包金额配置新增业务对象
     * @return
     */
    Boolean insertByAddBo(HuomaiGiftConfigAddBo bo);

    /**
     * 根据编辑业务对象修改红包金额配置
     * @param bo 红包金额配置编辑业务对象
     * @return
     */
    Boolean updateByEditBo(HuomaiGiftConfigEditBo bo);

    /**
     * 校验并删除数据
     * @param ids 主键集合
     * @param isValid 是否校验,true-删除前校验,false-不校验
     * @return
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
