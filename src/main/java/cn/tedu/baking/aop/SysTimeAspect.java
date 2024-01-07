package cn.tedu.baking.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Slf4j
@Aspect
public class SysTimeAspect {
       @Pointcut("@annotation(cn.tedu.baking.aop.RequiredTime)")
    private void timePointCut() {

    }

     @Around("timePointCut()")
    public Object notice1(ProceedingJoinPoint joinPoint) throws Throwable {
        long t1 = System.currentTimeMillis();
        Object result = joinPoint.proceed();//wan2()
        long t2 = System.currentTimeMillis();
        log.info("共耗时 {} 毫秒", (t2 - t1));
        System.out.println(result);
        return result;
    }
}
