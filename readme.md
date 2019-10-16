## spring cloud 例程

## 例子一

### eureka-server
注册中心

端口：8761

### face-server
人脸服务端

端口：8762，8763，启动两个实例


### face-clinet
人脸客户端

端口：8764

通过 http://localhost:8764/compare?name=stillcoolme 请求 face-server

ribbon会将请求均匀分给每个 face-server 实例


### 此时的架构
1. 服务注册中心 eureka-server
2. 人脸服务端 face-server 工程跑了两个实例，端口分别为8762,8763，分别向服务注册中心注册
3. 人脸客户端 face-clinet 端口为8764，向服务注册中心注册
4. 当 face-clinet 通过 restTemplate 调用 face-server 的 compare 接口时，因为用ribbon进行了负载均衡，会轮流的调用 face-server：8762和8763 两个端口的hi接口；

