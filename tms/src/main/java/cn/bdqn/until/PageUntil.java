package cn.bdqn.until;

import cn.bdqn.bean.News;
import cn.bdqn.bean.Role;

import java.util.List;

public class PageUntil {

        private Integer pageSize;    //每页数据大小
        private Integer pageIndex;   //当前页码
        private Integer totalCount;   //总记录数
        private Integer totalPage;    //总页数
        private List<Role> list;     //每页查询的数据
        private String rolename;      //查询的条件
        private List<News> listNews;

    public PageUntil(Integer pageSize, Integer pageIndex, Integer totalCount, Integer totalPage, List<Role> list, String rolename) {
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.list = list;
        this.rolename = rolename;
    }

    public PageUntil() {
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Override
    public String toString() {
        return "PageUntil{" +
                "pageSize=" + pageSize +
                ", pageIndex=" + pageIndex +
                ", totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", list=" + list +
                ", rolename='" + rolename + '\'' +
                '}';
    }

    public List<News> getListNews() {
        return listNews;
    }

    public void setListNews(List<News> listNews) {
        this.listNews = listNews;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<Role> getList() {
        return list;
    }

    public void setList(List<Role> list) {
        this.list = list;
    }





}
