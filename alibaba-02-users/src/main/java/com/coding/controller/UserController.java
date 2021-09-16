package com.coding.controller;

import com.coding.feignclients.ProductsFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Value("${server.port}")
    private String port;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private ProductsFeign productsFeign;

    @RequestMapping("user")
    public String user(){

        //Ribbon提供的负载均衡请求
//        ServiceInstance products = loadBalancerClient.choose("PRODUCTS");
//        String result = new RestTemplate().getForObject(products.getUri() + "/product", String.class);

        //openfeign方式调用
        String product = productsFeign.product(10);

        log.info("用户服务已启动...");
        return "this is User Service, my port is: " + port + " | " + product;
    }
}
