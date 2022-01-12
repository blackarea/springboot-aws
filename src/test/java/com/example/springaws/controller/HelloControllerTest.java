package com.example.springaws.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloControllerTest {

    @Test
    public void helloReturnTest(){
        String hello = "hello";

        Assertions.assertThat(hello).isEqualTo("hello");
    }


}