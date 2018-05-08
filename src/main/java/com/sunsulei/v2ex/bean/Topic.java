package com.sunsulei.v2ex.bean;

public class Topic {

    //id
    private Integer id;
    //标题
    private String title;
    //地址
    private String url;
    //内容
    private String content;
    //渲染后内容
    private String content_rendered;
    //回复数量
    private Integer replies;
    //所属节点
    private Node node;


    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", content='" + content + '\'' +
                ", content_rendered='" + content_rendered + '\'' +
                ", replies=" + replies +
                ", node=" + node +
                '}';
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent_rendered() {
        return content_rendered;
    }

    public void setContent_rendered(String content_rendered) {
        this.content_rendered = content_rendered;
    }

    public Integer getReplies() {
        return replies;
    }

    public void setReplies(Integer replies) {
        this.replies = replies;
    }
}
