package cn.bdqn.bean;

import java.util.Date;

public class News_Comment {
    private  int id;
    private int newsid;
    private String content;
    private String author;
    private Date createDate;

    public News_Comment() {
    }

    public News_Comment(int id, int newsid, String content, String author, Date createDate) {
        this.id = id;
        this.newsid = newsid;
        this.content = content;
        this.author = author;
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "News_Comment{" +
                "id=" + id +
                ", newsid=" + newsid +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNewsid() {
        return newsid;
    }

    public void setNewsid(int newsid) {
        this.newsid = newsid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
