package com.care.hi_board.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberConteroller {
	@Autowired private MemberService service;
	
	@RequestMapping("index")
	public String index() {
		return "member/index";
	}
	
	@RequestMapping("header")
	public String header() {
		return "default/header";
	}
	
	@RequestMapping("main") 
	public String main() {
		return "default/main";
	}
	
	@RequestMapping("footer") 
	public String footer() {
		return "default/footer";
	}
	
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	@PostMapping("loginProc")
	public String loginProc(MemberDTO member) {
		String result = service.loginProc(member);
		if(result.equals("로그인 성공")) {
			return "redirect:index";
		}
		return "member/login";
	}

}
