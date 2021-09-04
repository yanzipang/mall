package com.atguigu.common.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author hgk
 * @Date 2021/9/4 11:40
 * @description
 */

/**
 * 自定义校验注解的校验器：必须实现ConstraintValidator接口
 * ConstraintValidator接口有两个泛型
 *      第一个泛型指定哪个注解
 *      第二个类型指定校验什么类型的数据
 */
public class ListValueConstraintValidator implements ConstraintValidator<ListValue,Integer> {

    // 存储所有可能的值
    private Set<Integer> set = new HashSet<>();

    /**
     * 初始化方法-获取ListValue注解的详细信息
     * @param constraintAnnotation 校验注解
     */
    @Override
    public void initialize(ListValue constraintAnnotation) {
        int[] value = constraintAnnotation.value();
        for (int val : value) {
            set.add(val);
        }
    }

    /**
     * 判断是否校验成功
     * @param value 需要校验的值,即前端传过来的值
     * @param context 校验上下文环境
     * @return
     */
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        boolean flag = set.contains(value);
        return flag;
    }
}
