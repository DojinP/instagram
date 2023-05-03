package com.multi.instagram.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	@Autowired
	BoardAbstractService service;
	
	@RequestMapping("/main.do")
	public ModelAndView mainPage(HttpServletRequest request, String boardcontext) {
		ModelAndView mav = new ModelAndView("main/instagram_main_page");
		List<BoardDTO> boardlist = service.selectBoard();
		
		mav.addObject("boardlist", boardlist);
		return mav;
	}
	
	@RequestMapping("/board/content/insertPage")
	public String showCreatePage() {
		return "main/instagram_create_new_board_content";
	}
	
	@RequestMapping("/board/content/insert.do")
	public String createBoard(String boardcontext) {
		service.createBoard(boardcontext);
		return "main/instagram_main_page";
	}
	
	// ================== new ======================
	
	@RequestMapping(value="/view/cmtprt.do", produces="application/text; charset=UTF-8")
	public String commentPrint() {
		String view = "layout/instagram_board_popup";
		
		return view;
	}
	
	
	
}
