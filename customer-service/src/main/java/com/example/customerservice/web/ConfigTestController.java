package com.example.customerservice.web;

import com.example.customerservice.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigTestController {
   /* @Value("${global.params.p1}")
    private int p1;
    @Value("${global.params.p1}")
    private int p2;
    @Value("${customer.params.x}")
    private int x;
    @Value("${customer.params.x}")
    private int y;

    @GetMapping("/config")
    public Map<String, Integer> configTest() {
        return Map.of("p1", p1, "p2", p2, "x", x, "y", y);
    }*/

    @Autowired
    private GlobalConfig globalConfig;

    @GetMapping("/config")
    public GlobalConfig configTest() {
        return globalConfig;
    }
}
