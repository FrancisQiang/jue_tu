package com.tf.advice;

import com.alibaba.fastjson.JSON;
import com.tf.exception.GlobalException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Objects;

/**
 * @author lgq
 * @date 2020/1/23
 */
@Component
@Aspect
@Slf4j
public class LogAspect {

    private static class LogContent {
        HashMap<String, String> parameterMap;
        String remoteAddr;
        String requestUrl;

        LogContent(HashMap<String, String> parameterMap,
                   String remoteAddr, String requestUrl) {
            this.parameterMap = parameterMap;
            this.remoteAddr = remoteAddr;
            this.requestUrl = requestUrl;
        }
    }

    /**
     * 设置切点表达式，设置所有controller中的方法
     */
    @Pointcut("execution(public * com.tf.controller..*.*(..))")
    public void pointcut() {
    }

    /**
     * 后置
     * @param proceedingJoinPoint 切点
     */
    @Around(value = "pointcut()")
    public Object logInfo(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LogContent content = getContent(proceedingJoinPoint);
        long start = System.currentTimeMillis();
        Object object = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        double during = (end - start) / 1000.0;
        log.info("请求Url：" + content.requestUrl + "，请求地址：" + content.remoteAddr + "，请求参数：" +
                JSON.toJSONString(content.parameterMap) + "，处理时长：" + during + "ms。");
        return null;
    }

    @AfterThrowing(value = "pointcut()", throwing = "ex")
    public void logError(JoinPoint joinPoint, Exception ex) {
        LogContent content = getContent(joinPoint);
        String errorMessage = "";
        if (ex instanceof GlobalException) {
            GlobalException globalException = (GlobalException)ex;
            errorMessage = "{code:" + globalException.getCodeMessage().getCode() +
                    "，message:" + globalException.getCodeMessage().getMessage() + "}";
        } else {
            errorMessage = ex.getMessage();
        }
        log.info("请求URI：" + content.requestUrl + "，请求地址：" + content.remoteAddr + "，请求参数：" +
                JSON.toJSONString(content.parameterMap) + "，错误信息：" + errorMessage);
    }

    private LogContent getContent(JoinPoint joinPoint) {
        // MethodSignature类中可以获取参数名称，
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        String[] parameterNames = signature.getParameterNames();
        HashMap<String, String> parameterMap = new HashMap<>(8);
        for (int i = 0; i < args.length; i++) {
            parameterMap.put(parameterNames[i], args[i].toString());
        }
        // 通过 RequestContextHolder 获取当前线程的请求。
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest();
        String remoteAddr = request.getRemoteAddr();
        String requestUrl = request.getRequestURI();
        return new LogContent(parameterMap, remoteAddr, requestUrl);
    }


}
