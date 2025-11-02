package com.sadik.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class HelloController {

    @Autowired
    private Environment environment;

    @Value("${app.version:unknown}")
    private String version;

    @GetMapping("/hello")
    public Map<String, String> hello() {
        String activeProfile = environment.getActiveProfiles()[0];
        return Map.of("message", "Hello from Spring DevOps Lab!",
                "version", version,
                "profile", activeProfile);
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "UP");
    }
}
