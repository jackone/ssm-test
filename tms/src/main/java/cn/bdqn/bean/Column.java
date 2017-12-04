package cn.bdqn.bean;

import java.util.ArrayList;
import java.util.List;

public class Column {
    private  String syscode;
    private Integer columncode;
    private String columnname;
    private Integer sort;
    private String parentcode;
    private  Integer status;
    private   String remark;
    //子权限集合  tree控件进行绑定
    private List<Column> children=new ArrayList<Column>();

    public Column() {
    }

    public Column(String syscode, Integer columncode, String columnname, Integer sort, String parentcode, Integer status, String remark, List<Column> children) {
        this.syscode = syscode;
        this.columncode = columncode;
        this.columnname = columnname;
        this.sort = sort;
        this.parentcode = parentcode;
        this.status = status;
        this.remark = remark;
        this.children = children;
    }

    public String getSyscode() {
        return syscode;
    }

    public void setSyscode(String syscode) {
        this.syscode = syscode;
    }

    public Integer getColumncode() {
        return columncode;
    }

    public void setColumncode(Integer columncode) {
        this.columncode = columncode;
    }

    public String getColumnname() {
        return columnname;
    }

    public void setColumnname(String columnname) {
        this.columnname = columnname;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getParentcode() {
        return parentcode;
    }

    public void setParentcode(String parentcode) {
        this.parentcode = parentcode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Column> getChildren() {
        return children;
    }

    public void setChildren(List<Column> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Column{" +
                "syscode='" + syscode + '\'' +
                ", columncode=" + columncode +
                ", columnname='" + columnname + '\'' +
                ", sort=" + sort +
                ", parentcode='" + parentcode + '\'' +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                ", children=" + children.size() +
                '}';
    }
}
