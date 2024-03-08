package com.example.customerservice.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "global.params")
@Getter
@Setter
@NoArgsConstructor
public class GlobalConfig {
    private int p1;
    private int p2;

    GlobalConfig(int p1, int p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
}