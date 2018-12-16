package pers.phd.feignconsume.configure;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 定义Feign 日志级别
 *
 * @author panhaidong
 * @date 2018-12-16 22:15
 */
@Configuration
public class FeignFullLogConfiguration {
    @Bean
    Logger.Level feignLoggerLevel() {
        /**
         * 日志级别有四类
         * NONE 不记录任何信息
         * BASIC 仅记录请求方法、URL以及响应状态码和执行时间
         * HEADERS 除了记录BASIC级别的信息之外，还会记录请求和响应的头信息
         * FULL 记录所有请求与响应的明细，包括头信息、请求体、元数据等
         */
        return Logger.Level.FULL;
    }
}