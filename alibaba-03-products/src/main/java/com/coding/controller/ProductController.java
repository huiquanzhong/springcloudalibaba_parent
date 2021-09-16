package com.coding.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    @Value("${server.port}")
    private String port;

    @RequestMapping("product")
    public String product(Integer id){
        log.info("商品服务已启动..." + id);
       return "this is Product Service, my port is: " + port;
    }
}
