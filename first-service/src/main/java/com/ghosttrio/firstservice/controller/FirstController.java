package com.ghosttrio.firstservice.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/first-service")
public class FirstController {


    @GetMapping
    public String first(HttpServletRequest request) {
        log.info("port ===> {}", request.getServerPort());

        return "first";
    }

    @GetMapping("/message")
    public String message(@RequestHeader("first-request") String header) {
        log.info(header);
        return "first";
    }
}
