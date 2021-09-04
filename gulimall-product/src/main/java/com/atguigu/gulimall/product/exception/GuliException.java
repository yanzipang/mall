package com.atguigu.gulimall.product.exception;

import com.atguigu.common.exception.BizCodeEnum;
import com.atguigu.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/**
 * @Author hgk
 * @Date 2021/9/4 10:28
 * @description 异常处理类
 */

/**
 * basePackages:定义处理哪个包下的异常
 */
@Slf4j // 日志记录异常
@RestControllerAdvice(basePackages = "com.atguigu.gulimall.product")
public class GuliException {

    // @ExceptionHandler:声明捕获哪种类型的异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R handleVaildException(MethodArgumentNotValidException e) {
        // 记录异常
        log.error("数据校验出现异常：{}, 异常类型：{}", e.getMessage(), e.getClass());
        // 将错误信息封装成map返回
        Map<String, String> map = new HashMap<>();
        // 获取所有字段出错的错误信息--FieldError
        List<FieldError> fieldErrors = e.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            // 校验出错的字段
            String field = fieldError.getField();
            // 定义的错误提示消息
            String defaultMessage = fieldError.getDefaultMessage();
            // 封装结果
            map.put(field, defaultMessage);
            // 返回异常信息到前端
        }
        return R.error(BizCodeEnum.VALID_EXCEPTION.getCode(),BizCodeEnum.VALID_EXCEPTION.getMsg()).put("data",map);
    }

    // 全局异常
    @ExceptionHandler(Throwable.class)
    public R handleVaildException(Exception e) {
        // 记录异常
        log.error("数据校验出现异常：{}, 异常类型：{}", e.getMessage(), e.getClass());

        return R.error(BizCodeEnum.UNKNOW_EXEPTION.getCode(),BizCodeEnum.UNKNOW_EXEPTION.getMsg());
    }

}
