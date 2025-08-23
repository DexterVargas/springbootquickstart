package com.dexterv.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello")
    public String HelloWorld() {
        return "<h1>Hello World!</h1>";
    }
}
