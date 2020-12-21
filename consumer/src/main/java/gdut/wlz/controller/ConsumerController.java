package gdut.wlz.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import gdut.wlz.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: BUG_BOY
 * DATE:2020/11/29  15:48
 */
@RestController
@Slf4j
public class ConsumerController {

    /**
     * 工程之间调用使用的对象：http协议
     */
    @Resource
    private RestTemplate restTemplate;

    /**
     * 获取服务地址对象
     */
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/{id}")
    @HystrixCommand(fallbackMethod = "queryByIdFallback")
    public String queryById(@PathVariable Long id) {
        //获取对应的应用实例
        //List<ServiceInstance> instanceList = discoveryClient.getInstances("user-service");
        //获取注册中心的一个实例：可能同样的服务在不同的服务器注册到注册中心，选择其中一个执行
        //ServiceInstance serviceInstance = instanceList.get(0);
        //return restTemplate.getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/"+id, User.class);
        /*引入负载均衡ribbon的访问*/
        String url = "http://user-service/user/"+id;
        return restTemplate.getForObject(url, String.class);
    }
    public String queryByIdFallback(Long id) {
        log.error("用户查询失败",id);
        return "网络太拥挤了";
    }
}
