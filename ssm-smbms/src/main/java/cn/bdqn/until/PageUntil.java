package cn.bdqn.until;

import cn.bdqn.bean.Smbms_User;

import java.util.List;

public class PageUntil {

        private Integer pageSize;    //每页数据大小
        private Integer pageIndex;   //当前页码
        private Integer totalCount;   //总记录数
        private Integer totalPage;    //总页数
        private List<Smbms_User> list;     //每页查询的数据
        private String userName;      //查询的条件

    public PageUntil() {
    }

    public PageUntil(Integer pageSize, Integer pageIndex, Integer totalCount, Integer totalPage, List<Smbms_User> list, String userName) {
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.list = list;
        this.userName = userName;
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

    public List<Smbms_User> getList() {
        return list;
    }

    public void setList(List<Smbms_User> list) {
        this.list = list;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    @Override
    public String toString() {
        return "PageUntil{" +
                "pageSize=" + pageSize +
                ", pageIndex=" + pageIndex +
                ", totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", list=" + list +
                ", userName='" + userName + '\'' +
                '}';
    }
}
