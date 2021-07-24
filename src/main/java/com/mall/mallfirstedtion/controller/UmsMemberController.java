package com.mall.mallfirstedtion.controller;

import com.mall.mallfirstedtion.common.api.CommonResult;
import com.mall.mallfirstedtion.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wangzhe
 * @ClassName UmsMemberController
 * @create 2021-07-24 17:40
 * @description 添加根据电话号码获取验证码的接口和校验验证码的接口
 * 会员登录注册管理Controller
 * @Version 1.0
 */
@Controller
@Api(tags = "UmsMemberController",description = "会员登录注册管理")
@RequestMapping("/sso")
public class UmsMemberController {

    @Autowired
    private UmsMemberService memberService;

    @ApiOperation("获取验证码")
    @RequestMapping(value = "/getAuthCode",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAuthCode(@RequestParam String telephone){
        return memberService.generatorAuthCode(telephone);
    }

    @ApiOperation("判断验证码是否正确")
    @RequestMapping(value = "/verifyauthCode",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePassword(@RequestParam String telephone,
                                       @RequestParam String authCode){
        return memberService.verifyAuthCode(telephone,authCode);
    }
}
