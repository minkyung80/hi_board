package com.care.hi_board.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberConteroller {
	@Autowired private MemberService service;
	@Autowired private HttpSession session;
	
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
	
	@GetMapping("register")
	public String register() {
		return "member/register";
	}
	@PostMapping("registerProc")
	public String registerProc(MemberDTO member, String confirm) {
		String result = service.registerProc(member, confirm);
		if(result.equals("회원 등록 완료")) {
			return "redirect:index";
		}
		return "member/register";
	}
	
	@RequestMapping("memberInfo")
	public String memberInfo(
			@RequestParam(value="currentPage", required = false)String cp,
			String select, String search, Model model) {
		service.memberInfo(cp, select, search, model);
		return "member/memberInfo";
	}
	
	
	@GetMapping("update")
	public String update() {
		String id = (String)session.getAttribute("id");
		if(id == null || id.isEmpty()) {
			return "redirect:login";
		}
		return "member/update";
	}
	
	@PostMapping("updateProc")
	public String updateProc(MemberDTO member, String confirm) {
		String id = (String)session.getAttribute("id");
		if(id == null || id.isEmpty()) {
			return "redirect:login";
		}
		member.setId(id);
		String result = service.updateProc(member, confirm);
		if(result.equals("회원 정보 수정 완료")) {
			return "forward:logout";
		}
		return "member/update";
	}
	
	@GetMapping("delete")
	public String delete() {
		String id = (String)session.getAttribute("id");
		if(id == null || id.isEmpty()) {
			return "redirect:login";
		}
		return "member/delete";
	}
	
	@PostMapping("deleteProc")
	public String deleteProc(String pw, String confirmPw, Model model) {
		String id = (String)session.getAttribute("id");
		if(id == null || id.isEmpty()) {
			return "redirect:login";
		}
		
		String result = service.deleteProc(id, pw, confirmPw);
		model.addAttribute("msg", result);
		if(result.equals("회원 정보 삭제 완료")) {
			return "forward:logout";
		}
		return "member/delete";
	}
	
	

}
