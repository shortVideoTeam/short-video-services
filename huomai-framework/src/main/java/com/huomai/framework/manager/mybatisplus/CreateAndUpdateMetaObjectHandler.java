package com.huomai.framework.manager.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.huomai.common.utils.DateUtils;
import com.huomai.common.utils.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.util.StringUtils;

/**
 * MP注入处理器
 *
 * @author huomai
 * @date 2021/4/25
 */
@Slf4j
public class CreateAndUpdateMetaObjectHandler implements MetaObjectHandler {

	@Override
	public void insertFill(MetaObject metaObject) {
		try {
			//根据属性名字设置要填充的值
			if (metaObject.hasGetter("createTime")) {
				if (metaObject.getValue("createTime") == null) {
					this.setFieldValByName("createTime", DateUtils.getNowDate(), metaObject);
				}
			}
			if (metaObject.hasGetter("createBy")) {
				if (StringUtils.isEmpty(metaObject.getValue("createBy"))) {
					this.setFieldValByName("createBy", String.valueOf(SecurityUtils.getUserId()), metaObject);
				}
			}
		} catch (Exception e) {
			log.error("MP注入处理器发生错误", e);
		}

	}

	@Override
	public void updateFill(MetaObject metaObject) {
		try {
			if (metaObject.hasGetter("updateBy")) {
				if (StringUtils.isEmpty(metaObject.getValue("updateBy"))) {
					this.setFieldValByName("updateBy", String.valueOf(SecurityUtils.getUserId()), metaObject);
				}
			}
			if (metaObject.hasGetter("updateTime")) {
				if (metaObject.getValue("updateTime") == null) {
					this.setFieldValByName("updateTime", DateUtils.getNowDate(), metaObject);
				}
			}
		} catch (Exception e) {
			log.error("MP注入处理器发生错误", e);
		}

	}

}
