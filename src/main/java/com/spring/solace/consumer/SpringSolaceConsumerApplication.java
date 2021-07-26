package com.spring.solace.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.activation.MimeType;

@SpringBootApplication
@RestController
public class SpringSolaceConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSolaceConsumerApplication.class, args);
    }

    @PostMapping("/rest/tutorials")
    public String sayHello()  {
        return "Hello From Spring and Kubernetes example";
    }

    @GetMapping("/rest/tutorials")
    public String getHello()  {
        return "Hello From Spring and Kubernetes example";
    }

    @PostMapping(value="/T/rest/pubsub", consumes = MediaType.TEXT_PLAIN_VALUE)
    public void postHello(@RequestBody String str)  {
        System.out.println("Request:- " + str);
        //return "Hello From Spring and Kubernetes example";
    }
}
