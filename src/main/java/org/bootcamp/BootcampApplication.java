package org.bootcamp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//  Application Context 설정을 자동으로 수행
@SpringBootApplication
public class BootcampApplication {
    //
    public static void main(String[] args) {
        //
        SpringApplication.run(BootcampApplication.class, args);
    }
}
