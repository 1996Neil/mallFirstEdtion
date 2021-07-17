package com.mall.mallfirstedtion.service.impl;

import com.mall.mallfirstedtion.mbg.model.PmsBrand;
import com.mall.mallfirstedtion.service.PmsBrandService;
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
    @Override
    public List<PmsBrand> listAllBrand() {
        return null;
    }

    @Override
    public int createBrand(Long id, PmsBrand brand) {
        return 0;
    }

    @Override
    public int updateBrand(Long id, PmsBrand brand) {
        return 0;
    }

    @Override
    public int deleteBrand(Long id) {
        return 0;
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int PageSize) {
        return null;
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return null;
    }
}
