package com.grgbanking.faceclient.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    @HystrixCommand(fallbackMethod = "compareError")
    public String faceCompare(String name) {
        // 直接用的程序名替代了具体的url地址，在ribbon中它会根据服务名来选择具体的服务实例，根据服务实例在请求的时候会用具体的url替换掉服务名
        return restTemplate.getForObject("http://face-server-service/compare?name="+name, String.class);
    }

    // 服务端异常就会执行快速失败，直接返回一组字符串，而不是等待响应超时，这很好的控制了容器的线程阻塞。
    public String compareError(String name) {
        return "hi, "+name+", sorry, face server error!";
    }

}
