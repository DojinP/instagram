package com.multi.instagram.comment;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommentController {
	@Autowired
	CommentService service;
	
	
	@RequestMapping(value = "/comment/list.do", produces = "application/json;charset=utf-8")
	@ResponseBody			// board_id로 해당되는 게시글의 모든 댓글 조회
	public List<CommentDTO> list(String board_id) {
		List<CommentDTO> commentList = service.selectAll(board_id);
		
		return commentList;
	}
	
	@RequestMapping("/comment/insert.do")		// 댓글 작성
	public String insert(CommentDTO comment) {
		System.out.println(comment);
		service.insert(comment);
		return "redirect:/main.do";
	}
	
	@RequestMapping(value = "/comment/delete.do", produces = "application/text;charset=utf-8")
	@ResponseBody	
	// 댓글 삭제
	public int delete(String comment_id) {
		int delete = service.delete(comment_id);
		
		return delete;
	}
	
}
