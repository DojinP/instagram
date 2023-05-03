package com.multi.instagram.like;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LikeController {
	
	
	@RequestMapping("/like_test")
	public String showPage() {
		return "like/like_test";
	}
	
	@RequestMapping("/like.do")
	public String read(String user_id) {
		String view = "like/like_test";
		// System.out.println("like.do 실행 : " + user_id);
		// service.read(user_id);
//		String sql = "select board_id from like_table where user_id = ?";
//		String board_id = template.query(sql, user_id);
//		String sql = "select * from like_table where user_id = ?";
//		likeDTO likedto = template.query(sql, user_id);
		
		ModelAndView mav = new ModelAndView();
		
//		mav.addObject("board_id", board_id);
		
//		mav.setViewName("/view/cmtprt.do");
		return view;
	}
}
