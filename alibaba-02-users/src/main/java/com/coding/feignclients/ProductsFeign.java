package com.coding.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("PRODUCTS")
public interface ProductsFeign {

    @RequestMapping("product")
    String product(@RequestParam Integer id);
}
