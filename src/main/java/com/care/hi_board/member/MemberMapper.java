package com.care.hi_board.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	MemberDTO loginProc(String id);
	

}
