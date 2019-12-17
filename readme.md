## spring cloud 例程

## 例子一

### eureka-server 注册中心

端口：8761

### face-server 人脸服务端

端口：8762，8763，启动两个实例


### face-clinet 人脸客户端

端口：8764

通过 http://localhost:8764/compare?name=stillcoolme 请求 face-server

ribbon会将请求均匀分给每个 face-server 实例


### 此时的架构
1. eureka-server:服务注册中心，
2. face-server，人脸服务端，工程跑了两个实例，端口分别为8762,8763，分别向服务注册中心注册
3. face-clinet，人脸客户端，端口为8764，向服务注册中心注册
4. 当 face-clinet 通过 restTemplate 调用 face-server 的 compare 接口时，因为用ribbon进行了负载均衡，会轮流的调用 face-server：8762和8763 两个端口的hi接口；

## 例子二 添加prometheus

1. 启动完注册中心，再启动face-server；
2. 访问 http://localhost:8762/monitor/prometheus 可以看到暴露给Prometheus的监控项；
3. 将resources/prometheus.yml中相关job配置写到prometheus组件配置文件中，启动prometheus就可以得到监控信息了

参考：
[基于Prometheus搭建SpringCloud全方位立体控体系](http://www.throwable.club/2018/11/10/spring-cloud-prometheus/#%E5%9F%BA%E4%BA%8EPrometheus%E6%90%AD%E5%BB%BASpringCloud%E5%85%A8%E6%96%B9%E4%BD%8D%E7%AB%8B%E4%BD%93%E7%9B%91%E6%8E%A7%E4%BD%93%E7%B3%BB)
[使用 Spring Boot Actuator 监控应用](http://www.ityouknow.com/springboot/2018/02/06/spring-boot-actuator.html)