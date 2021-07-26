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

    @GetMapping(value="/rest/tutorials", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getHello()  {
        return "args\": {\n" +
                "    \"hello\": \"world\",\n" +
                "    \"solace\": \"cool\"\n" +
                "  }";
    }

    @PostMapping(value="/T/rest/pubsub", consumes = MediaType.TEXT_PLAIN_VALUE)
    public void postHello(@RequestBody String str)  {
        System.out.println("Request:- " + str);
        //return "Hello From Spring and Kubernetes example";
    }
}
