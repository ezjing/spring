package com.bitc.board1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;  // 최신버전에는 없어진 클래스로 나중에 최신버전으로 공부할 예정
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @Configuration : 스프링프레임워크에 해당 파일이 설정 파일임을 알려주는 어노테이션
// WebMvcConfigurer : 스프링프레임워크에서 사용하는 설정 정보가 있는 인터페이스, 사용자 설정이 필요할 경우 해당 인터페이스를 상속받아 수정함
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        // apache commons-fileupload 설정 객체 생성
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        // 사용할 문자셋 설정
        resolver.setDefaultEncoding("UTF-8");
        // 업로드할 파일의 최대 크기 설정(byte 단위 크기), (10메가, 10,000키로바이트, 10,000,000바이트)
        resolver.setMaxUploadSizePerFile(10 * 1024 * 1024);

        return resolver;
    }
}
