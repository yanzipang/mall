package com.atguigu.common.valid;

/**
 * @Author hgk
 * @Date 2021/9/4 11:19
 * @description 自定义注解，作用：检查showStatus字段的值是否是0或1，否则抛出异常
 */

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 自定义注解，作用：检查字段只能在指定的数组内
 * 在JSR303规范中，自定义校验注解必须有三个属性：
 *      message()错误信息
 *      groups()分组校验
 *      payload()自定义负载信息
 */
// 自定义注解
@Documented
// @Constraint：声明这个自定义注解使用哪个校验器进行校验，即关联自定义的校验器和自定义的校验注解
@Constraint(validatedBy = { ListValueConstraintValidator.class })
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ListValue {

    // 指明错误信息去哪里取
    String message() default "{com.atguigu.common.valid.ListValue.message}";

    // 支持分组校验功能
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    // 数组，需要用户自己指定---，表明可以在什么范围取值
    int[] value() default {}; // default {} ： 默认没有值
}

