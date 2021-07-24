package com.mall.mallfirstedtion.service;

/**
 * @author wangzhe
 * @ClassName RedisService
 * @create 2021-07-24 17:23
 * @description  * redis操作Service,
 * 对象和数组都以json形式进行存储
 * @Version 1.0
 */
public interface RedisService {

    /**
     * 存储数据
     * @Date 17:24 2021/7/24
     * @param key
     * @param value
     *@return  void
     **/
    void set(String key,String value);

    /**
     * 获取数据
     * @Date 17:27 2021/7/24
     * @param key
     *@return  java.lang.String
     **/
    String get(String key);

    /**
     * 设置超期时间
     * @Date 17:27 2021/7/24
     * @param key
 * @param expire
     *@return  boolean
     **/
    boolean expire(String key,long expire);

    /**
     * 删除数据
     * @Date 17:27 2021/7/24
     * @param key
     *@return  void
     **/
    void remove(String key);

    /**
     * 自增操作
     * @Date 17:27 2021/7/24
     * @param key
 * @param delta
     *@return  java.lang.Long
     **/
    Long increment(String key,long delta);
}
