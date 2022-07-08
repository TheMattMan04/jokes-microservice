package com.myorg.jokesservice.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("jokes-service")
@Data
public class Configuration {

    private String url;
}
