package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author hgk
 * @email sunlightcs@gmail.com
 * @date 2021-09-02 20:57:17
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
