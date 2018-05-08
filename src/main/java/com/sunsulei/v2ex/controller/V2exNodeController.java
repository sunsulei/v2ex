package com.sunsulei.v2ex.controller;

import com.sunsulei.v2ex.common.JsonResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class V2exNodeController {

    @RequestMapping(value = "node", method = RequestMethod.POST)
    public JsonResult node(@RequestBody String content) {

        return JsonResult.resultSuccess("asd");
    }

}
