package com.x.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.x.entity.Hot;
import com.x.service.impl.HotServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class Controller {
    @GetMapping("/")
    public String hello() {
        return "夏龙云 !!! Welcome !!! <(▰˘◡˘▰)>";
    }
}
