package pers.phd.feignconsume.service;

import org.springframework.cloud.openfeign.FeignClient;
import pers.phd.simply.service.HelloService;

/**
 * 引入外部公共接口
 *
 * @author panhaidong
 * @date 2018-12-16 18:13
 */
@FeignClient(value = "SIMPLY-PROVIDER")
public interface RefactorHelloService extends HelloService {
}