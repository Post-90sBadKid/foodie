package com.wry.foodie.api.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * <p>
 * APO 通知:
 * 1.前置通知: 方法正常调用之前调用
 * 2.后置通知: 方法正常调用之后调用
 * 3.环绕通知: 方法用前后调用
 * 4.异常通知: 方法用有异常后调用
 * 5.最终通知: 方法调用之后调用
 * </p>
 *
 * @author wangruiyu
 * @since 2020/11/29
 */
@Aspect
@Component
public class ServiceLogAspect {
    private static final Logger log = LoggerFactory.getLogger(ServiceLogAspect.class);


    @Around("execution(* com.wry.foodie.service.impl..*.*(..))")
    public Object recordTimeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("========开始执行{}.{}========", joinPoint.getTarget().getClass(), joinPoint.getSignature().getName());
        // 记录开始时间
        long begin = System.currentTimeMillis();
        // 执行目标方法
        Object proceed = joinPoint.proceed();
        // 记录结束时间
        long end = System.currentTimeMillis();
        long taskTime = end - begin;
        if (taskTime > 3000) {
            log.error("========执行结束,耗时:{} 毫秒========", taskTime);
        } else if (taskTime > 2000) {
            log.warn("========执行结束,耗时:{} 毫秒========", taskTime);
        } else {
            log.info("========执行结束,耗时:{} 毫秒========", taskTime);
        }
        return proceed;
    }


}
