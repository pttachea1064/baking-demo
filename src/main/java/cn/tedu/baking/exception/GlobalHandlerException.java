package cn.tedu.baking.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import cn.tedu.baking.response.JsonResult;
import cn.tedu.baking.response.StatusCode;


@RestControllerAdvice
@Slf4j
public class GlobalHandlerException {
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
}