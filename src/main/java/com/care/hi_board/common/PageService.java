package com.care.hi_board.common;

public class PageService {
	public static String printPage(String url, int currentPage, int totalCount, int pageBlock) {
		String result = "";
		// 이전
		if(currentPage <= 1){
			result += ("<a href='"+ url +"1'>[이전] </a>");
		}else{
			result += ("<a href='"+url+(currentPage-1)+"'>[이전]</a>");
		}
		
	// 중간 숫자목록
		int totalPage = totalCount / pageBlock;
		if(totalCount % pageBlock != 0)
			totalPage++;
		
		for(int i = 1; i <= totalPage; i++){
			result +="<a href='"+ url +i+"'>["+i+"] </a>";
		}
		
		//다음
		if(currentPage >= totalPage){
			result +="<a href='"+url+totalPage+"'>[다음] </a>";
		}else{
			result +="<a href='"+url + (currentPage+1)+"'>[다음] </a>";
		}
		
		return result;
	}

}
