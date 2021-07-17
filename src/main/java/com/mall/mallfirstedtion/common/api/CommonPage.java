package com.mall.mallfirstedtion.common.api;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author wangzhe
 * @ClassName CommonPage
 * @create 2021-07-17 12:44
 * @description 分页数据封装类
 * @Version 1.0
 */
public class CommonPage<T> {
    private Integer pageNum;
    private Integer pageSize;
    private Integer totalPage;
    private Long total;
    private List<T> list;
/**
 * 将pageHelper分页后的list转为分页信息
 * @Date 14:08 2021/7/17
 *@return  com.mall.mallfirstedtion.common.api.CommonPage<T>
 **/
    public static <T> CommonPage<T> restPage(List<T> list){
        CommonPage<T> result = new CommonPage<>();
        PageInfo<T> pageInfo = new PageInfo<>();
        result.setTotalPage(pageInfo.getPages());
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotal(pageInfo.getTotal());
        result.setList(pageInfo.getList());
        return result;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
