package com.spotify.javaspotifyapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class JavaSpotifyApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaSpotifyApiApplication.class, args);
    }

}
