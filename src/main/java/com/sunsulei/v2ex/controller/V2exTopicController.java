package com.sunsulei.v2ex.controller;

import com.sunsulei.v2ex.bean.Member;
import com.sunsulei.v2ex.bean.Topic;
import com.sunsulei.v2ex.common.JsonResult;
import com.sunsulei.v2ex.common.RedisUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class V2exTopicController {


    @RequestMapping(value = "topic", method = RequestMethod.POST)
    public JsonResult topic(@RequestBody String content) {

        return JsonResult.resultSuccess("asd");
    }


    @RequestMapping(value = "topic")
    public JsonResult topic() {
        Set<String> keys = RedisUtil.keys(Topic.class);

        Member member = RedisUtil.get("Livid", Member.class);

        return JsonResult.resultSuccess(member);
    }

}
