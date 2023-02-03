package com.pe.sh.Veterinaria;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VeterinariaApplication {

        @Bean
        public ModelMapper modelMapper(){
            return new ModelMapper();
        }
    
	public static void main(String[] args) {
		SpringApplication.run(VeterinariaApplication.class, args);
	}

}
