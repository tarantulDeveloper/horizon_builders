package com.horizonbuilders.server.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CloudinaryConfiguration {
    @Value("${cloud.name}")
    String cloud;

    @Value("${api.secret}")
    String api_secret;

    @Value("${api.key}")
    String api_key;

    @Bean
    Cloudinary cloudinary() {


        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloud,
                "api_key", api_key,
                "api_secret", api_secret
        ));


    }
}
