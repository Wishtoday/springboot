package com.example.springboot.mdc;

import com.example.springboot.util.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

import org.slf4j.MDC;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName LogInterceptor.java
 * @Description 拦截器设置uuid
 * @createTime 2021年12月28日 10:26:00
 */

@Component
public class LogInterceptor extends HandlerInterceptorAdapter {
    /**
     * 日志跟踪标识,在logback文件加上[%X{TRACE_ID}]
     */
    private static final String TRACE_ID = "TRACE_ID";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (StringUtils.isEmpty(MDC.get(TRACE_ID))) {
            String traceId = UUID.randomUUID().toString();
            MDC.put(TRACE_ID, traceId);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        MDC.remove(TRACE_ID);
    }
}
