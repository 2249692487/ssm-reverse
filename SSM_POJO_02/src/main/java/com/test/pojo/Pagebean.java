package com.test.pojo;

import java.util.List;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2019/1/10
 */
public class Pagebean<T> {
    // 当前页码
    private int pageNum;
    // 分页显示数据
    private List<T> pagedata;
    // 总记录数
    private Long totalCount;

    public int getPrePage() {
        return prePage;
    }

    @Override
    public String toString() {
        return "Pagebean{" +
                "pageNum=" + pageNum +
                ", pagedata=" + pagedata +
                ", totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", numPerPage=" + numPerPage +
                ", isIsFirstPage=" + isIsFirstPage +
                ", isIsLastPage=" + isIsLastPage +
                ", prePage=" + prePage +
                ", nextPage=" + nextPage +
                '}';
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    // 总页数
    private int totalPage;
    // 每页显示条数
    private int numPerPage;
    public boolean isIsFirstPage;
    public boolean isIsLastPage;
    public int prePage;
    public int nextPage;

    public boolean isIsFirstPage() {
        return isIsFirstPage;
    }

    public void setIsFirstPage(boolean isFirstPage) {
        isIsFirstPage = isFirstPage;
    }

    public boolean isIsLastPage() {
        return isIsLastPage;
    }

    public void setIsLastPage(boolean isLastPage) {
        isIsLastPage = isLastPage;
    }





    public Pagebean() {
    }

    public Pagebean(List<T> pagedata) {
        this.pagedata = pagedata;
    }


    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getNumPerPage() {
        return numPerPage;
    }

    public void setNumPerPage(int numPerPage) {
        this.numPerPage = numPerPage;
    }

    public List<T> getPagedata() {
        return pagedata;
    }

    public void setPagedata(List<T> pagedata) {
        this.pagedata = pagedata;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }


}
