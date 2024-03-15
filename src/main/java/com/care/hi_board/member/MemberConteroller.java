package com.care.hi_board.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberConteroller {
	
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

}
