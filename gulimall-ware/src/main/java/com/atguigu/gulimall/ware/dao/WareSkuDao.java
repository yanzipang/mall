package com.atguigu.gulimall.ware.dao;

import com.atguigu.gulimall.ware.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品库存
 * 
 * @author hgk
 * @email sunlightcs@gmail.com
 * @date 2021-09-02 21:00:26
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {
	
}
