package com;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import scala.App;

@SpringBootApplication
public class PracApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(App.class);
        application.setBannerMode(Banner.Mode.CONSOLE);
        application.run(args);
    }
}
