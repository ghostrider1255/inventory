package com.javasree.ms.inventory.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();

        /*modelMapper.createTypeMap(PrivilegeDto.class, Privilege.class)
            .addMapping( PrivilegeDto::getName, Privilege::setName);
*/
        return modelMapper;
    }
}
