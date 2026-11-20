package com.tchaikop.sbb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration  //설정파일

public class SecurityConfig {
	
	
	
	//비밀번호암호화
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain fiterChain(HttpSecurity http) throws Exception{
		http
			.authorizeHttpRequests(auth -> auth  //권한부여
				//	.anyRequest().permitAll() //누구나 모든 페이지에 접근가능
					
				//로그인 페이지나 호원가입 페이지 처럼 누구나 봐야할 페이지만 접근가능하게 설정
				.requestMatchers(
						"/",
						"/login",
						"/signup",
						"/css/**",
						"/img/**",
						"/js/**"
						
						).permitAll()
				
				.requestMatchers(
						"/admin"
						).hasRole("ADMIN")
					
				//위 요청들을 제외한 요청들은 모두 로그인 해야만 접근 가능한 요청
				.anyRequest().authenticated()
				
		)
			//로그인 설정
		.formLogin(login -> login
				.loginPage("/user/login")   //로그인 페이지(로그인 요청 )등록
				.loginProcessingUrl("/user/login")
				.defaultSuccessUrl("/",true)  //로그인 성공할때 이동할 페이지 -> root
				.permitAll()
				
				)
		
		.logout(logout -> logout
				.logoutUrl("/logout")
				.logoutSuccessUrl("/")
				.invalidateHttpSession(true)  //세션에 올라와 있는 로그인 정보 삭제
				.deleteCookies("JSESSIONID") //쿠키 삭제는 안해도 되
				
				);
		
		
		return http.build();	
	}

}
