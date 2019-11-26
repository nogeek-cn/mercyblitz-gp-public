package com.darian.annotationdriverdevelopment.config;

import com.darian.annotationdriverdevelopment.demain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 * User 配置 Bean
 */
@Configuration
public class UserConfiguration {

    @Bean(name = "user")
    public User user(){
        User user = new User();
        user.setName("darian-annotation");
        return user;
    }
}
