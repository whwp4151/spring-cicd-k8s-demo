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
        Map<String, String> message = Map.of("message", "Hello from Spring DevOps Lab!",
                "version", version,
                "profile", activeProfile);
        System.out.println(message);
        return message;
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "UP");
    }

    @GetMapping("/cpu-test")
    public String cpuIntensiveTask() {
        long start = System.currentTimeMillis();
        long end = start + 10_000; // 10초 동안 반복

        long count = 0;
        while (System.currentTimeMillis() < end) {
            isPrime(count++);
        }

        String message = "CPU test finished. Last number checked: " + count;
        System.out.println(message);
        return message;
    }

    private boolean isPrime(long n) {
        if (n < 2) return false;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
