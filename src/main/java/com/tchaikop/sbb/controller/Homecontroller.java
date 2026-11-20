package com.tchaikop.sbb.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tchaikop.sbb.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor

public class Homecontroller {
	private final UserService userService;
		@GetMapping("/")
		public String root() {
			return "index";
		}
		

			@GetMapping("/admin")
			public String admin() {
				return "admin";
			}
			
			
			@GetMapping("/login")
			public String login() {
				return "login";
			}
			
			@GetMapping("/logout")
			public String logout() {
				return "logout";
			}
			
			@GetMapping("/signup")
			public String signupForm() {
				return "signup";
			}
			
			@PostMapping("/signup")
			public String signup(
					@RequestParam("username") String username,
					@RequestParam("password") String password,
					@RequestParam("email") String email
					
					
					
					) {
				userService.create(username,password,email);
				return "redirect:/login";
			}
			
			
			
		//	@PreAuthorize("isAuthenticated()")
			@GetMapping("/userinfo")
			public String userinfo() {
				return "userinfo";
			}
			
}
