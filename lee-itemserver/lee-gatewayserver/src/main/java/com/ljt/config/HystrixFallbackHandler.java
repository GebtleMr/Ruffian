package com.ljt.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

/**
  *
  * 定义 fallback 处理器
  *
**/
@Component
public class HystrixFallbackHandler implements HandlerFunction<ServerResponse> {

    private Logger log = LoggerFactory.getLogger(HystrixFallbackHandler.class);
    private MultiValueMap<String,String> map = new LinkedMultiValueMap();

    @PostConstruct
    private void init() {
        map.add("code","9999");
        map.add("message","服务异常");
    }

    @Override
    public Mono<ServerResponse> handle(ServerRequest serverRequest) {
        serverRequest.attribute(ServerWebExchangeUtils.GATEWAY_ORIGINAL_REQUEST_URL_ATTR)
            .ifPresent(originalUrls -> log.error("网关执行请求:{}失败,hystrix服务降级处理", originalUrls));

        return ServerResponse
            .status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON).body(map,map.getClass());
    }
}