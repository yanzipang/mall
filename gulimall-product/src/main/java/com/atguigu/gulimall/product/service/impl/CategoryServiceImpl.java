package com.atguigu.gulimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> queryCategoryEntityList() {
        // 查出所有
        List<CategoryEntity> list = baseMapper.selectList(null);
        // 组装树形结构
        List<CategoryEntity> collect = list.stream().filter(categoryEntity -> categoryEntity.getParentCid() == 0)
                .map(k -> {
                    k.setChildrenList(this.getChildren(k, list));
                    return k;
                }).sorted((c1,c2) ->{
                    return (c1.getSort()==null?0:c1.getSort()) - (c2.getSort()==null?0: c2.getSort());
                })
                .collect(Collectors.toList());
        return collect;
    }

    @Override
    public void removeMenuByIds(List<Long> asList) {
        // TODO 检查要删除的记录是否被其他地方引用

        // 逻辑删除
        baseMapper.deleteBatchIds(asList);
    }

    // 递归查找所有子类
    private List<CategoryEntity> getChildren(CategoryEntity categoryEntity, List<CategoryEntity> list) {
        List<CategoryEntity> collect = list.stream().filter(k -> k.getParentCid().equals(categoryEntity.getCatId()))
                .map(categoryEntity1 -> {
                    // 递归找子菜单
                    categoryEntity1.setChildrenList(getChildren(categoryEntity1, list));
                    return categoryEntity1;
                }).sorted((c1,c2) ->{
                    return (c1.getSort()==null?0:c1.getSort()) - (c2.getSort()==null?0: c2.getSort());
                })
                .collect(Collectors.toList());
        return collect;
    }

}