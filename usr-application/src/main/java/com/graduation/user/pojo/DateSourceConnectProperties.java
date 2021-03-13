package com.graduation.user.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhangxue
 */
@ConfigurationProperties(prefix = "duird")
@Component
@Getter
@Setter
@ToString
public class DateSourceConnectProperties {
    private String username;
    private String url;
    private String password;
    private String driverClassName;
}
