package cn.tedu.baking.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class SysNoticeAspect {
    @Pointcut("bean(testController)")
    public void doNotice() {

    }

    @Before("doNotice()")
    public void doBefore() {
        log.warn("@Before: 前置通知执行了~");
    }

    @After("doNotice()")
    public void doAfter() {
        log.warn("@After: 后置通知执行了~");
    }


    @AfterReturning("doNotice()")
    public void doAfterReturning() {
        log.warn("@AfterReturning: 返回后通知执行了~");
    }


    @AfterThrowing("doNotice()")
    public void doAfterThrowing() {
        log.warn("@AfterThrowing: 抛出异常后通知执行了~");
    }

    @Around("doNotice()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.warn("@Around: 环绕通知在方法执行前执行了~");
        Object proceed = joinPoint.proceed();
        log.warn("@Around: 环绕通知在方法执行后执行了~");
        return proceed;
    }
}
