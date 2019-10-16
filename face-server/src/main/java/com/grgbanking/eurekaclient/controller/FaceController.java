package com.grgbanking.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: stillcoolme
 * @date: 2019/10/16 14:50
 * @description:
 */
@RestController
public class FaceController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/compare")
    public String compare(@RequestParam String name) {
        return "hi "+name+", score:" + port;
    }
}
