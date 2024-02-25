package com.annotation.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect
@Slf4j
public class LogAspect {

    @Pointcut("@annotation(com.annotation.RequestLog)")
    public void logAspect() {
    }

    /**
     * AOP日志管理
     *
     * @param joinPoint
     */
    @Before("logAspect()")
    public void beforePkhLog(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        String methodName = joinPoint.getSignature().getName();
        System.out.println("========================================= Method " + methodName + "() begin=========================================");
        // 执行时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = new Date();
        String time = sdf.format(d);
        System.out.println("Time           : " + time);
        // 打印请求 URL
        System.out.println("URL :            " + request.getRequestURL());
        // 打印 请求方法
        System.out.println("HTTP Method:     " + request.getMethod());
        // 打印controller 的全路径以及执行方法
        System.out.println("Class Method   : " + joinPoint.getSignature().getDeclaringTypeName() + "." + methodName);
        // 打印请求的 IP
        System.out.println("IP             : " + request.getRemoteHost());
        // 打印请求入参
        //System.out.println("Request Args   : " + JSON.toJSONString(joinPoint.getArgs()));
//        Object[] args = joinPoint.getArgs();
//        if (Objects.nonNull(args)) {
//            List<Object> argsList = Arrays.asList(args);
//            // 将 HttpServletResponse 和 HttpServletRequest 参数移除，不然会报异常
//            List<Object> collect = argsList.stream()
//                    .filter(o -> !(o instanceof HttpServletResponse || o instanceof HttpServletRequest))
//                    .collect(Collectors.toList());
//            collect.toArray(args);
//        }
//        System.out.println("Request Args   : " + JSON.toJSONString(args));
        System.out.println("=======================================================================================================");
    }

    @After("logAspect()")
    public void afterPkhLog(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        log.info("========================================= Method " + methodName + "() end =========================================");
    }
}
