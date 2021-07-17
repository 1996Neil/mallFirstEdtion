package com.mall.mallfirstedtion.controller;

import com.mall.mallfirstedtion.common.api.CommonResult;
import com.mall.mallfirstedtion.mbg.model.PmsBrand;
import com.mall.mallfirstedtion.service.PmsBrandService;
import org.mybatis.generator.api.CommentGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

/**
 * @author wangzhe
 * @ClassName PmsBrandController
 * @create 2021-07-17 12:09
 * @description 品牌管理controller
 * @Version 1.0
 */
@Controller
@RequestMapping("/brand")
public class PmsBrandController {
    @Autowired
    private PmsBrandService pmsBrandService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);


    public CommonResult<List<PmsBrand>> getBrandList(){
        return null;
    }
}
