package com.spring.solace.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(value="/rest/tutorials")
    public ResponseEntity getHello()  {
        Person person = new Person("Consumer1");
        return new ResponseEntity(person, HttpStatus.OK);
    }

    @PostMapping(value="/T/rest/pubsub")
    public void postHello(@RequestBody String str)  {
        System.out.println("Request:- " + str);
        //return "Hello From Spring and Kubernetes example";
    }

    class Person {
        public String getName() {
            return name;
        }

        String name;

        Person(String name) {
            this.name = name;
        }
    }

}
