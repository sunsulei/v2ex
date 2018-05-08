package com.sunsulei.v2ex.controller;

import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.sunsulei.v2ex.bean.Member;
import com.sunsulei.v2ex.bean.Node;
import com.sunsulei.v2ex.bean.Topic;
import com.sunsulei.v2ex.common.Constants;
import com.sunsulei.v2ex.common.JsonResult;
import com.sunsulei.v2ex.common.RedisUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class V2exMemberController {

    @RequestMapping(value = "member", method = RequestMethod.GET)
    public JsonResult member(@RequestParam String username) {

        Member member = RedisUtil.get(username, Member.class);
        return JsonResult.resultSuccess(member);

    }

    @RequestMapping(value = "member", method = RequestMethod.POST)
    public JsonResult initMember(@RequestBody String content) {
        Document doc = Jsoup.parse(JSONUtil.parseObj(content).getStr("content"));
        String username = doc.getElementsByTag("h1").get(0).text();
        Member member = Member.getMember(username);
        Element element = doc.getElementsByClass("content").get(1).getElementsByClass("box").get(1);
        Elements cell_item = element.getElementsByClass("cell item");
        List<Topic> topics = new ArrayList<>(cell_item.size());
        for (Element topicEle : cell_item) {
            Element item_title = topicEle.getElementsByClass("item_title").get(0);
            String title = item_title.child(0).text();
            Integer id = ReUtil.getFirstNumber(item_title.child(0).attr("href"));

            Element nodeEle = topicEle.getElementsByClass("node").get(0);
            String nodeName = StrUtil.subAfter(nodeEle.attr("href"), "/", true);
            Node node = Node.getNode(nodeName);
            Topic topic = new Topic();
            topic.setNode(node);
            if (topicEle.getElementsByClass("count_livid").size() > 0) {
                Integer replies = ReUtil.getFirstNumber(topicEle.getElementsByClass("count_livid").get(0).text());
                topic.setReplies(replies);
            }
            topic.setId(id);
            topic.setUrl(Constants.TOPIC_URL + id);
            topic.setTitle(title);
            topics.add(topic);
        }
        member.setTopics(topics);
        RedisUtil.set(member.getUsername(), member, -1L);
        return JsonResult.resultSuccess(member.getUsername());
    }

}
