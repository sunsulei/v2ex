package com.sunsulei.v2ex.bean;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.sunsulei.v2ex.common.Constants;
import com.sunsulei.v2ex.common.RedisUtil;

public class Node {
    //节点id
    private Integer id;
    //名称
    private String name;
    //节点中文名
    private String title;
    //节点备用名
    private String title_alternative;
    //节点地址
    private String url;
    //节点主题数量
    private Integer topics;
    //头像小
    private String avatar_mini;
    //头像中
    private String avatar_normal;
    //头像大
    private String avatar_large;

    public static Node getNode(String nodeName) {
        Node node = RedisUtil.get(nodeName, Node.class);
        if (node == null) {
            node = JSONUtil.toBean(HttpUtil.get(Constants.API_NODE_URL + nodeName), Node.class);
            RedisUtil.set(nodeName, node, -1L);
        }
        return node;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle_alternative() {
        return title_alternative;
    }

    public void setTitle_alternative(String title_alternative) {
        this.title_alternative = title_alternative;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getTopics() {
        return topics;
    }

    public void setTopics(Integer topics) {
        this.topics = topics;
    }

    public String getAvatar_mini() {
        return avatar_mini;
    }

    public void setAvatar_mini(String avatar_mini) {
        this.avatar_mini = avatar_mini;
    }

    public String getAvatar_normal() {
        return avatar_normal;
    }

    public void setAvatar_normal(String avatar_normal) {
        this.avatar_normal = avatar_normal;
    }

    public String getAvatar_large() {
        return avatar_large;
    }

    public void setAvatar_large(String avatar_large) {
        this.avatar_large = avatar_large;
    }
}
