package com.sunsulei.v2ex.bean;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.sunsulei.v2ex.common.Constants;
import com.sunsulei.v2ex.common.RedisUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Member {

    //成员id
    private String id;
    //所有主题
    private List<Topic> topics;
    //用户是否存在
    private String status;                 //": "found",
    //用户地址
    private String url;                 //": "http://www.v2ex.com/member/sunsulei",
    //用户名
    private String username;                 //": "sunsulei",
    //个人一些地址
    private String website;                 //": "",
    private String twitter;                 //": "",
    private String psn;                 //": "",
    private String github;                 //": "",
    private String btc;                 //": "",
    private String location;                 //": "",
    private String tagline;                 //": "",
    private String bio;                 //": "",
    //头像小
    private String avatar_mini;                 //": "//cdn.v2ex.com/avatar/7f58/918f/215634_mini.png?m=1491814565",
    //头像中
    private String avatar_normal;                 //": "//cdn.v2ex.com/avatar/7f58/918f/215634_normal.png?m=1491814565",
    //头像大
    private String avatar_large;                 //": "//cdn.v2ex.com/avatar/7f58/918f/215634_large.png?m=1491814565",
    private String created;                 //": 1487300536

    public static Member getMember(String username) {
        Member member = RedisUtil.get(username, Member.class);
        if (member == null) {
            member = JSONUtil.toBean(HttpUtil.get(Constants.API_MEMBER_NAME_URL + username), Member.class);
        }
        return member;
    }

    public static Member getMemberById(String id) {
        return JSONUtil.toBean(HttpUtil.get(Constants.API_MEMBER_ID_URL + id), Member.class);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        Map<Integer, Topic> map = new HashMap<>();
        if (this.getTopics() != null) {
            topics.addAll(this.getTopics());
        }
        for (Topic topic : topics) {
            Integer topicId = topic.getId();
            if (map.containsKey(topicId)) {
                Topic temp = map.get(topicId);
                int tempLenth = temp.toString().length();
                int topicLenth = topic.toString().length();
                if (topicLenth > tempLenth) {
                    map.put(topicId, topic);
                }

            } else {
                map.put(topicId, topic);
            }
        }
        this.topics = new ArrayList<>(map.values());
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getPsn() {
        return psn;
    }

    public void setPsn(String psn) {
        this.psn = psn;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getBtc() {
        return btc;
    }

    public void setBtc(String btc) {
        this.btc = btc;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
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

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}