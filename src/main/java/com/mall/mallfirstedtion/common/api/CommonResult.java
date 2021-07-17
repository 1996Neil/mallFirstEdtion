package com.mall.mallfirstedtion.common.api;

/**
 * @author wangzhe
 * @ClassName CommonResult
 * @create 2021-07-17 12:44
 * @description 通用返回对象
 * @Version 1.0
 */
public class CommonResult<T> {
    private long code;
    private String message;
    private T data;

    protected CommonResult() {

    }

    protected CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * @return com.mall.mallfirstedtion.common.api.CommonResult<T>
     * @Description: 返回成功结果
     * @Date 13:02 2021/7/17
     * @Param [data]
     **/
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);

    }

    /**
     * 返回成功结果
     *
     * @param data    获取的数据
     * @param message 提示信息
     *                com.mall.mallfirstedtion.common.api.CommonResult<T>
     * @Date 13:49 2021/7/17
     **/
    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * @return com.mall.mallfirstedtion.common.api.CommonResult<T>
     * @Description: 失败返回结果
     * @Date 13:12 2021/7/17
     * @Param [errorCode] 错误码
     **/
    public static <T> CommonResult<T> failed(IErrorCode errorCode) {
        return new CommonResult<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回信息
     *
     * @param message 提示信息
     *                com.mall.mallfirstedtion.common.api.CommonResult<T>
     * @Date 13:46 2021/7/17
     **/
    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<T>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 返回失败信息
     *
     * @return com.mall.mallfirstedtion.common.api.CommonResult<T>
     * @Date 13:52 2021/7/17
     **/
    public static <T> CommonResult<T> failed() {
        return failed(ResultCode.FAILED);
    }

    /**
     * 参数验证失败返回结果
     *
     * @return com.mall.mallfirstedtion.common.api.CommonResult<T>
     * @Date 13:57 2021/7/17
     **/
    public static <T> CommonResult<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     *
     * @param message 提示信息
     * @return com.mall.mallfirstedtion.common.api.CommonResult<T>
     * @Date 13:57 2021/7/17
     **/
    public static <T> CommonResult<T> validateFailed(String message) {
        return new CommonResult<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     *
     * @param data 获取的数据
     * @return com.mall.mallfirstedtion.common.api.CommonResult<T>
     * @Date 14:01 2021/7/17
     **/
    public static <T> CommonResult<T> unauthorized(T data) {
        return new CommonResult<>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), null);
    }

    /**
     * 未授权返回结果
     *
     * @param data 获取的数据
     * @return com.mall.mallfirstedtion.common.api.CommonResult<T>
     * @Date 14:01 2021/7/17
     **/
    public static <T> CommonResult<T> forbidden(T data) {
        return new CommonResult<>(ResultCode.FORBIDDEN.getCode(), ResultCode.UNAUTHORIZED.getMessage(), null);
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
