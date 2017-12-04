package cn.bdqn.bean;


public class News {
    private String information_code;
    private String columntype;
    private String title;
    private String titlecolor;
    private String outerlink;
    private Integer weight;
    private String  weightdate;
    private String image_url;
    private String primaryword;
    private String summary;
    private String publish_time;
    private String content;
    private String go_time;
    private Integer create_by;
    private String create_date;
    private Integer update_by;
    private String update_date;
    private Integer state;
    private String remark;
    private Integer status;

    public News() {
    }

    @Override
    public String toString() {
        return "News{" +
                "information_code='" + information_code + '\'' +
                ", columntype='" + columntype + '\'' +
                ", title='" + title + '\'' +
                ", titlecolor='" + titlecolor + '\'' +
                ", outerlink='" + outerlink + '\'' +
                ", weight=" + weight +
                ", weightdate='" + weightdate + '\'' +
                ", image_url='" + image_url + '\'' +
                ", primaryword='" + primaryword + '\'' +
                ", summary='" + summary + '\'' +
                ", publish_time='" + publish_time + '\'' +
                ", content='" + content + '\'' +
                ", go_time='" + go_time + '\'' +
                ", create_by=" + create_by +
                ", create_date='" + create_date + '\'' +
                ", update_by=" + update_by +
                ", update_date='" + update_date + '\'' +
                ", state=" + state +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                '}';
    }

    public String getInformation_code() {
        return information_code;
    }

    public void setInformation_code(String information_code) {
        this.information_code = information_code;
    }

    public String getColumntype() {
        return columntype;
    }

    public void setColumntype(String columntype) {
        this.columntype = columntype;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitlecolor() {
        return titlecolor;
    }

    public void setTitlecolor(String titlecolor) {
        this.titlecolor = titlecolor;
    }

    public String getOuterlink() {
        return outerlink;
    }

    public void setOuterlink(String outerlink) {
        this.outerlink = outerlink;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getWeightdate() {
        return weightdate;
    }

    public void setWeightdate(String weightdate) {
        this.weightdate = weightdate;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getPrimaryword() {
        return primaryword;
    }

    public void setPrimaryword(String primaryword) {
        this.primaryword = primaryword;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(String publish_time) {
        this.publish_time = publish_time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getGo_time() {
        return go_time;
    }

    public void setGo_time(String go_time) {
        this.go_time = go_time;
    }

    public Integer getCreate_by() {
        return create_by;
    }

    public void setCreate_by(Integer create_by) {
        this.create_by = create_by;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public Integer getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(Integer update_by) {
        this.update_by = update_by;
    }

    public String getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(String update_date) {
        this.update_date = update_date;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
