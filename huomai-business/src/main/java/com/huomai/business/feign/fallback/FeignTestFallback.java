package com.huomai.business.feign.fallback;


import com.huomai.business.feign.FeignTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * feign测试fallback
 *
 * @author huomai
 */
@Slf4j
@Component
public class FeignTestFallback implements FeignTestService {

	@Override
	public String search(String wd) {
		log.error("fallback");
		return "报错啦";
	}
}
