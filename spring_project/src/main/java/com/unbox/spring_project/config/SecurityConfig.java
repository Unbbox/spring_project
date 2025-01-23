package com.unbox.spring_project.config;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Configuration // @Component(@Controller, @Service) : 객체 생성, 환경설정 담당
@EnableWebSecurity // SpringSecurity 기능을 사용하기 위한 어노테이션
public class SecurityConfig {

	@Bean // 스프링 시큐리티 기능을 사용하고자 할 때 사용
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		// csrf 부터 중요도가 떨어져 더이상 안쓰이는 코드
		// csrf 해킹기법으로부터 보호조치 코드 방법 => 추후 js에 csrf 보호기능 넣을 것
		.csrf(csrf -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
		// cors: 특정 서버로만 데이터 넘길 수 있도록 설정
		.cors(cors -> cors.configurationSource(corsConfigurationSource()))
		// 세션설정
		.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
		// 여기까지 중요도 떨어짐
		
		.authorizeHttpRequests(authorize -> authorize
				.requestMatchers("/", "/loginPage", "/logout", "/noticeCheckPage", "/registerPage", "/menu/all").permitAll()
				.requestMatchers(HttpMethod.POST, "/login", "/register").permitAll()
				// resources, WEB-INF 하위 폴더 전부 허용
				.requestMatchers("/resources/**", "/WEB-INF/**").permitAll()
				.requestMatchers("/noticeAddPage", "/noticeModifyPage").hasAnyAuthority("ADMIN", "MANAGER")
				.requestMatchers(HttpMethod.POST, "/menu/add").hasAnyAuthority("ADMIN", "MANAGER")
				.requestMatchers(HttpMethod.POST, "/menu/update").hasAnyAuthority("ADMIN", "MANAGER")
				.requestMatchers(HttpMethod.DELETE, "/menu/delete").hasAnyAuthority("ADMIN", "MANAGER")
				.anyRequest().authenticated() // 로그인 해야지만 접근이 가능하게끔 함. 그렇게 때문에 로그인 페이지로 리다이렉팅
				)
		.formLogin(
				// url을 작성해서 로그인페이지로 이동할 때
				login -> login
				.loginPage("/loginPage") 
				.loginProcessingUrl("/login")
				.failureUrl("/loginPage?error=true") // 로그인 실패했을 때 이동 할 주소
				// usernameParameter, passwordParameter은 요소 name 이름의 변경이 있을 떄 작성, 기본 값(username, password)으로 작성 시 생략 가능				
				.usernameParameter("username") // 로그인할 때 (input 태그의 name 값과 동일하게 작성)
				.passwordParameter("password") // 
				.successHandler(authenticationSuccessHandler()) // 로그인 성공 후 리턴 주소 지정
				.permitAll()
				)
		.logout(logout -> logout
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/") // 로그아웃 성공 후 해당 url로 리다이렉팅
				.invalidateHttpSession(true) // 세션 무효화
				.deleteCookies("JSESSIONID") // 쿠키 삭제
				.permitAll()
				);
		
		return http.build();
	}
	
	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new SimpleUrlAuthenticationSuccessHandler() {
			
			@Override
			// 로그인 성공 시 특별한 기능을 넣을 때 사용(세션, 권한)
			public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
					Authentication authentication) throws IOException, ServletException {
				HttpSession session = request.getSession(); // 세션 기능을 가져온 것
				boolean isManager = authentication.getAuthorities().stream()
						.anyMatch(grantedAuthority -> 
						grantedAuthority.getAuthority().equals("ADMIN") |
						grantedAuthority.getAuthority().equals("MANAGER"));
				
				if(isManager) {
					session.setAttribute("MANAGER", true);
				}
				session.setAttribute("username", authentication.getName());
				session.setAttribute("isAuthenticated", true);
				// request.getContextPath() => localhost:8080
				response.sendRedirect(request.getContextPath()+"/");
				
				super.onAuthenticationSuccess(request, response, authentication);
			}
		};
	}
	
	// 비밀번호 암호화
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		// localhost:8080 서버에서는 프론트에서 백엔드단 또는 백엔드단에서 프론트단인데 데이터를 주고받을 수 있게 만든 것
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:8080", "https://localhost:8080"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
		configuration.setAllowedHeaders(Arrays.asList("Authorization", "Context-Type"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		
		return source;
	}
}
