package com.grgbanking.faceclient;

import com.grgbanking.faceclient.service.FaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: stillcoolme
 * @date: 2019/10/16 16:34
 * @description:
 */
@RestController
public class FaceControler {

    @Autowired
    FaceService faceService;
    @RequestMapping(value = "/compare")
    public String compare(@RequestParam String name){
        return faceService.faceCompare(name);
    }

}
