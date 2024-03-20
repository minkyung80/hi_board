package com.care.hi_board.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

@Service
public class MemberService {
	@Autowired private MemberMapper memberMapper;
	@Autowired private HttpSession session;
	
	public String loginProc(MemberDTO member) {
		if(member.getId() == null || member.getId().isEmpty()) {
			return "아이디를 입력하세요.";
		} 
		
		if(member.getPw() == null || member.getPw().isEmpty()) {
			return "비밀번호를 입력하세요.";
		}
		MemberDTO result = memberMapper.loginProc(member.getId());
			if(result != null) {
				BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();
				
				if(bpe.matches(member.getPw(), result.getPw())) {
					session.setAttribute("id",result.getId());
					session.setAttribute("userName",result.getUserName());
					session.setAttribute("address",result.getAddress());
					session.setAttribute("mobile",result.getMobile());
					return "로그인 성공";
				}
			}
			return "아이디/비밀번호를 확인 후 다시 시도하세요.";
	}

}
