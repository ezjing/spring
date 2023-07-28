package com.bitc.securityquiz.configuration;

import com.bitc.securityquiz.data.entity.Member;
import com.bitc.securityquiz.service.MemberDetailService;
import com.bitc.securityquiz.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
public class SecurityConfiguration {

    private final MemberDetailService memberDetailService;

    // 스프링 시큐리티에서는 무조건 암호화된 비밀번호를 사용해야 함
    // 비밀번호 인코더 사용 설정
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 스프링 시큐리티 설정 무시 항목 추가
    @Bean
    public WebSecurityCustomizer configure() {
        return (web) -> web.ignoring()
                .requestMatchers("/static/**");
    }

    // 스프링 시큐리티 필터 설정
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // authorizeRequests() : 인증 목록 설정
        // requestMatchers(url) : 사용자 요청 주소 매핑
        // permitAll() : 모든 권한 허용
        // anyRequest() : 모든 요청, authorizeRequests()의 마지막에 있어야 함(순서 중요)
        // authenticated() : 권한 인증 필요
        // and() : 추가 옵션 설정 시 사용
        // formLogin() : 로그인 폼 화면 사용
        // loginPage(url) : 사용자 지정 로그인 화면 url 설정
        // defaultSuccessUrl(url) : 로그인 성공 시 출력할 화면 url 설정
        // logout() : 로그아웃 사용 여부
        // logoutSuccessUrl(url) : 로그아웃 성공 시 출력할 화면 url 설정
        // invalidateHttpSession() : 모든 세션 정보 삭제
        // csrf().disable() : 사용자 권한 탈취 공격 방어 사용 안함(.disable() 안넣으면 기본값으로 방어 기능 사용하는 설정임)
        // cors().disabled() :
        return http
                .authorizeRequests()
                .requestMatchers("/login", "/signup", "/user").permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/articles")
                .and().logout()
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true)
                .and().csrf().disable()
//                .and().cors().disable() // 리액트와 사용할때 필요 지금은 필요 없음
                .build();
    }

    // 사용 권한 인증 관리자 설정
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, MemberService memberService) throws Exception {

        // 선생님 파일 참고하여 메모 옮겨적기
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                // 스프링시큐리티에서 제공하는 UserDetailService 인터페이스를 구현한 UserDetailService 클래스의 객체를 매개변수로 사용함
                // 데이터 베이스에 있는 사용자 정보를 가져와서 사용 권한 인증 관리자에 넘겨줌
                .userDetailsService(memberDetailService)
                .passwordEncoder(bCryptPasswordEncoder)
                .and()
                .build();
    }
}

// 클라이언트 요청 -> 필터(security) -> 컨트롤러 -> 서비스 -> DB 순으로 동작함