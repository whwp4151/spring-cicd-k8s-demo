package com.sadik.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class SpringCicdK8sDemoApplication {

	public static void main(String[] args) {
        // 애플리케이션 시작 전에 기본 타임존을 KST로 설정
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));

		SpringApplication.run(SpringCicdK8sDemoApplication.class, args);
	}

}
