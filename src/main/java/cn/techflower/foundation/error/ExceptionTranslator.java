package cn.techflower.foundation.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.stream.Collectors;


@ControllerAdvice(basePackages = {"cn.techflower"})
public class ExceptionTranslator {

    private final Logger logger = LoggerFactory.getLogger(ExceptionTranslator.class);

    @ExceptionHandler
    public ResponseEntity<Object> handleBusinessException(BusinessException ex, NativeWebRequest request) {
        logger.error("处理" + request.getContextPath() + "请求系统业务异常,如下:", ex);
        return ResponseEntity.badRequest().body(ex);
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleBusinessException(BindException ex, NativeWebRequest request) {
        logger.error("处理" + request.getContextPath() + "请求系统业务异常,如下:", ex);
        logger.error(ex.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining()));
        String errorMessage = ex.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining("\r\n"));
        return ResponseEntity.badRequest().body(new BusinessException(errorMessage));
    }
}
