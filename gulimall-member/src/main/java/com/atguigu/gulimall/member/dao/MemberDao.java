package com.atguigu.gulimall.member.dao;

import com.atguigu.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author hgk
 * @email sunlightcs@gmail.com
 * @date 2021-09-02 20:46:56
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
