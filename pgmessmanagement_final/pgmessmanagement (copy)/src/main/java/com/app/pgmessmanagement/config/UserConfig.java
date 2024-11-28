package com.app.pgmessmanagement.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
