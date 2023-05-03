package com.multi.instagram.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommentController {
	@Autowired
	CommentService service;
	
	@RequestMapping("/comment/list.do")			// board_id로 해당되는 게시글의 모든 댓글 조회
	public ModelAndView list(String board_id) {
		ModelAndView mav = new ModelAndView();
		String view = "";
		List<CommentDTO> commentList = service.selectAll(board_id);
		mav.addObject("commentList", commentList);
		
		mav.setViewName(view);
		return mav;
	}
	
	@RequestMapping("/comment/insert.do")		// 댓글 작성
	public String insert(CommentDTO comment) {
		String view = "";
		int res = service.insert(comment);
		
		return view;
	}
	
	@RequestMapping("/comment/delete.do")		// 댓글 삭제
	public String delete(String comment_id) {
		String view = "";
		int res = service.delete(comment_id);
		
		return view;
	}
		
	@RequestMapping("/comment/update.do")		// 댓글 수정
	public String update(CommentDTO comment) {
		String view = "";
		int res = service.update(comment);
		
		return view;
	}
	
	@RequestMapping("/comment/read.do")			// 댓글 조회	(당장 사용안함)
	public ModelAndView read(String board_id, String user_id) {
		ModelAndView mav = new ModelAndView();
		String view = "";
		CommentDTO comment = service.read(board_id, user_id);
		mav.addObject("comment", comment);
		
		mav.setViewName(view);
		return mav;
	}
}
