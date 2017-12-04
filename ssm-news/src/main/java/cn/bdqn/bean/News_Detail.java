package cn.bdqn.bean;

import java.util.Date;
import java.util.List;

public class News_Detail {
    private Integer id;
    private String title;
    private String summary;
    private String author;
    private Date createdate;
    private List<News_Comment> commentList;


    public News_Detail() {
    }

    public News_Detail(Integer id, String title, String summary, String author, Date createdate, List<News_Comment> commentList) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.author = author;
        this.createdate = createdate;
        this.commentList = commentList;
    }

    public List<News_Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<News_Comment> commentList) {
        this.commentList = commentList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    @Override
    public String toString() {
        return "News_Detail{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", author='" + author + '\'' +
                ", createdate=" + createdate +
                ", commentList=" + commentList +
                '}';
    }
}
