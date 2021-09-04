package com.atguigu.gulimall.product.entity;

import com.atguigu.common.valid.AddGroup;
import com.atguigu.common.valid.ListValue;
import com.atguigu.common.valid.UpdateGroup;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;

/**
 * 品牌
 * 
 * @author hgk
 * @email sunlightcs@gmail.com
 * @date 2021-09-01 20:19:26
 */

/**
 * JSR303数据校验标准
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 * 		groups：分组校验
	 */
	@TableId
	@Null(message = "新增时不能指定id", groups = {AddGroup.class})
	@NotNull(message = "修改时必须指定id", groups = {UpdateGroup.class})
	private Long brandId;

	/**
	 * 品牌名
	 */
	@NotBlank(message = "品牌名不能为空", groups = {AddGroup.class,UpdateGroup.class})
	private String name;

	/**
	 * 品牌logo地址
	 * 		因为没有加非空校验，所以其实不传也可以，但是传了就必须同时走@URL的校验
	 */
	@URL(message = "url地址不合法")
	private String logo;

	/**
	 * 介绍
	 */
	@NotBlank(message = "品牌介绍不能为空")
	private String descript;

	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	/**
	 * 使用自定义注解，作用：使这个字段的值只能是0或1
	 */
	@ListValue(value = {0,1}, groups = {AddGroup.class})
	private Integer showStatus;

	/**
	 * 检索首字母
	 */
	/**
	 * @Pattern:自定义校验规则
	 * 		regexp:使用正则表达式校验
	 * 	"/^[a-zA-Z]$/" ： 以小写和大写的a-z开头和结束
	 */
	@Pattern(regexp = "^[a-zA-Z]$", message = "检索首字母必须是一个字母",groups = {AddGroup.class,UpdateGroup.class})
	private String firstLetter;

	/**
	 * 排序
	 */
	@Min(value = 0, message = "排序字段最小不能低于0")
	private Integer sort;

}
