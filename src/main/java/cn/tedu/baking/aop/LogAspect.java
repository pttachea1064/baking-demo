package cn.tedu.baking.aop;

import cn.tedu.baking.pojo.entity.Log;
import cn.tedu.baking.service.LogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
@Slf4j
public class LogAspect {
    @Around("@annotation(RequiredLog)")
    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
        log.warn("開始記錄");
        int status = 1;
        String error = null;
        long time = 0L;

        long t1 = System.currentTimeMillis();
        try {
            Object result = joinPoint.proceed();
            long t2 = System.currentTimeMillis();
            time = t2 - t1;
            return result;
        } catch (Throwable throwable) {
            long t3 = System.currentTimeMillis();
            time = t3 - t1;
            status = 0;
            error = throwable.getMessage();
            throw throwable;
        } finally {
            saveLog(joinPoint, time, status, error);
        }
    }

    @Autowired
    private LogService service;


    private void saveLog(ProceedingJoinPoint joinPoint, long time, int status, String error) throws NoSuchMethodException, JsonProcessingException {

        ServletRequestAttributes requestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String ip = request.getRemoteAddr();

        String username = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            UserDetails principal = (UserDetails) authentication.getPrincipal();
            if (principal != null) {
                username = principal.getUsername();
            }
        }

        Class<?> targetCls = joinPoint.getTarget().getClass();

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        Method targetMethod = targetCls.getDeclaredMethod(
                signature.getName(),
                signature.getParameterTypes());

        RequiredLog annotation = targetMethod.getAnnotation(RequiredLog.class);

        String operation = annotation.value();

        String method = targetCls.getName() + "." + targetMethod.getName();

        String params = new ObjectMapper().writeValueAsString(joinPoint.getArgs());
        Log log = new Log();
        log.setTime(time);
        log.setStatus(status);
        log.setError(error);
        log.setIp(ip);
        log.setCreatedTime(new Date());
        log.setUsername(username);
        log.setOperation(operation);
        log.setMethod(method);
        log.setParams(params);
        service.insert(log);
    }
}
