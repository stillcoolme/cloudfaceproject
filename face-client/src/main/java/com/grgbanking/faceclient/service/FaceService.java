package com.grgbanking.faceclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author: stillcoolme
 * @date: 2019/10/16 16:27
 * @description:
 */
@Service
public class FaceService {

    @Autowired
    RestTemplate restTemplate;

    public String faceCompare(String name) {
        // 直接用的程序名替代了具体的url地址，在ribbon中它会根据服务名来选择具体的服务实例，根据服务实例在请求的时候会用具体的url替换掉服务名
        return restTemplate.getForObject("http://face-server-service/compare?name="+name, String.class);
    }

}
