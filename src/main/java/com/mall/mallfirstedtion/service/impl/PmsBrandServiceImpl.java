package com.mall.mallfirstedtion.service.impl;

import com.github.pagehelper.PageHelper;
import com.mall.mallfirstedtion.mbg.mapper.PmsBrandMapper;
import com.mall.mallfirstedtion.mbg.model.PmsBrand;
import com.mall.mallfirstedtion.mbg.model.PmsBrandExample;
import com.mall.mallfirstedtion.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangzhe
 * @ClassName PmsBrandServiceImpl
 * @create 2021-07-17 12:35
 * @description
 * @Version 1.0
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {
    @Autowired
    private PmsBrandMapper brandMapper;
    @Override
    public List<PmsBrand> listAllBrand() {
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int createBrand(PmsBrand brand) {
        return brandMapper.insertSelective(brand);
    }

    @Override
    public int updateBrand(Long id, PmsBrand brand) {
        brand.setId(id);
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public int deleteBrand(Long id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int PageSize) {
        PageHelper.startPage(pageNum,PageSize);
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }
}
