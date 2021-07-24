package com.mall.mallfirstedtion.service;

import com.mall.mallfirstedtion.common.api.CommonResult;

/**
 * @author wangzhe
 * @ClassName UmsMemberService
 * @create 2021-07-24 17:45
 * @description
 * @Version 1.0
 */
public interface UmsMemberService {

    /**
     * 生成验证码
     * @Date 17:47 2021/7/24
     * @param telephone
     *@return  com.mall.mallfirstedtion.common.api.CommonResult
     **/
    CommonResult generatorAuthCode(String telephone);

    /**
     * 确认验证码
     * @Date 17:47 2021/7/24
     * @param telephone
     * @param authCode
     *@return  com.mall.mallfirstedtion.common.api.CommonResult
     **/
    CommonResult verifyAuthCode(String telephone,String authCode);
}
