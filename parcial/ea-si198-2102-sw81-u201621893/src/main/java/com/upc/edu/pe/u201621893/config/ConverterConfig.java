package com.upc.edu.pe.u201621893.config;

import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class ConverterConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
