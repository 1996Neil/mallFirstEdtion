package com.mall.mallfirstedtion.service;

import com.mall.mallfirstedtion.mbg.model.PmsBrand;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangzhe
 * @ClassName PmsBrandService
 * @create 2021-07-17 12:12
 * @description
 * @Version 1.0
 */
public interface PmsBrandService {
    /**
     * @return java.util.List<com.mall.mallfirstedtion.mbg.model.PmsBrand>
     * @Description: 列出全部的品牌信息
     * @Date 12:13 2021/7/17
     * @Param [PmsBrand]
     **/
    List<PmsBrand> listAllBrand();

    int createBrand(Long id, PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int PageSize);

    PmsBrand getBrand(Long id);
}
