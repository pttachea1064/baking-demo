package cn.tedu.baking.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import cn.tedu.baking.response.JsonResult;
import cn.tedu.baking.response.StatusCode;

import java.nio.file.AccessDeniedException;


@RestControllerAdvice
@Slf4j
public class GlobalHandlerException {
    //全部的異常處理
    @ExceptionHandler(IllegalArgumentException.class)
    public JsonResult doHandleIllegalArgumentException(IllegalArgumentException e) {
        log.warn("IllegalArgumentException msg is {}", e.getMessage());
        return new JsonResult(StatusCode.OPERATION_FAILED, e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public JsonResult doHandleRuntimeException(RuntimeException e) {
        log.error("RuntimeException msg is {}", e.getMessage());
        return new JsonResult(StatusCode.OPERATION_FAILED, e.getMessage());
    }

    //權限使用問題
    @ExceptionHandler(AccessDeniedException.class)
    public JsonResult handleAccessDeniedException(AccessDeniedException e){
        log.warn("無權限使用");
        return new JsonResult(StatusCode.FORBIDDEN_ERROR);
    }
}