package com.atguigu.gulimall.product.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.atguigu.common.valid.AddGroup;
import com.atguigu.common.valid.UpdateGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.gulimall.product.entity.BrandEntity;
import com.atguigu.gulimall.product.service.BrandService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.R;

import javax.validation.Valid;


/**
 * 品牌
 *
 * @author hgk
 * @email sunlightcs@gmail.com
 * @date 2021-09-01 21:06:02
 */
@RestController
@RequestMapping("product/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("product:brand:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = brandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    // @RequiresPermissions("product:brand:info")
    public R info(@PathVariable("brandId") Long brandId){
		BrandEntity brand = brandService.getById(brandId);

        return R.ok().put("brand", brand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("product:brand:save")
    // @Valid:是为了告诉spring-mvc,我们的这个字段是需要校验的，不加这个注解的则不进行校验
    /**
     * @Valid:是为了告诉spring-mvc,我们的这个字段是需要校验的，不加这个注解的则不进行校验
     * BindResult:里面封装了@Valid校验后的结果
     */
    /**
     * Validated：指定校验分组
     */
    public R save(@Validated({AddGroup.class}) @RequestBody BrandEntity brand /*, BindingResult bindingResult*/){
//        // 如果校验出错
//        if (bindingResult.hasErrors()) {
//            // 将错误信息封装成map返回
//            Map<String,String> map = new HashMap<>();
//            // 获取所有字段出错的错误信息--FieldError
//            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
//            for (FieldError fieldError : fieldErrors) {
//                // 校验出错的字段
//                String field = fieldError.getField();
//                // 定义的错误提示消息
//                String defaultMessage = fieldError.getDefaultMessage();
//                // 封装结果
//                map.put(field,defaultMessage);
//            }
//
//            return R.error(400,"提交的数据不合法").put("data",map);
//        }
		brandService.save(brand);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("product:brand:update")
    public R update(@Validated({UpdateGroup.class}) @RequestBody BrandEntity brand){
		brandService.updateById(brand);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("product:brand:delete")
    public R delete(@RequestBody Long[] brandIds){
		brandService.removeByIds(Arrays.asList(brandIds));

        return R.ok();
    }

}
