package com.multi.instagram.board;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.multi.instagram.member.MemberDTO;
import com.multi.instagram.member.MemberService;

@Controller
public class BoardController {
	@Autowired
	BoardAbstractService boardservice;
	
	@Autowired
	MemberService memberserivce;
	
	@Autowired
	BoardFileUploadLogic fileUploadService;
	
	@RequestMapping("/main.do")
	public ModelAndView mainPage() {
		ModelAndView mav = new ModelAndView("main/instagram_main_page");
		List<BoardDTO> boardlist = boardservice.selectBoard();
		List<BoardFileDTO> boardfilelist = boardservice.selectFile();
		List<MemberDTO> memberlist = memberserivce.member_list();
//		System.out.println(boardlist);
//		System.out.println(boardfilelist);
//		System.out.println(memberlist);
		mav.addObject("boardlist", boardlist);
		mav.addObject("boardfilelist", boardfilelist);
		mav.addObject("memberlist", memberlist);
		return mav;
	}
	
	@RequestMapping("/board/content/insert.do")
	public String createBoard(BoardDTO board, HttpSession session) throws IllegalStateException, IOException {
//		System.out.println(board);
		//board에 값 저장
		MemberDTO loginUser = (MemberDTO)session.getAttribute("loginUser");
		board.setWriterId(loginUser.getId());
		
		//1. multipartFile 정보를 추출
		List<MultipartFile> files = board.getBoardfiles();
		//2. 업로드될 서버의 경로 - 실제 서버의 경로를 추출
		String path = WebUtils.getRealPath(session.getServletContext(), "/WEB-INF/upload");
		System.out.println(path);
		//3. 파일 업로드 서비스를 호출해서 실제 서버에 업로드되도록 작업하기
		List<BoardFileDTO> boardfiledtolist = fileUploadService.uploadFiles(files, path);
		int count = 1; // deptImageFileno의 값 세팅

		for(BoardFileDTO boardfiledto: boardfiledtolist) {
			boardfiledto.setBoardImageFileno(count+"");
			count++;
		}
		
		//4. DB에 저장하기
		boardservice.insertBoard(board, boardfiledtolist);
		return "redirect:/main.do";
	}
	
	
	@RequestMapping("/board/delete.do")
	public String deleteBoard(String board_id) {
		boardservice.deleteBoard(board_id);
		return "redirect:/main.do";
	}
	
	@RequestMapping(value = "/board/read.do", produces = "application/json;charset=utf-8")
	@ResponseBody
	public BoardUploadDTO readBoard(String board_id, String writer_id) {
		BoardUploadDTO boardupload = boardservice.readBoard(board_id, writer_id);
//		System.out.println(board_id+","+writer_id);
//		System.out.println(boardupload);
		return boardupload;
	}
	
	@RequestMapping("/board/update.do")
	public String updateBoard(String boardContent, String boardId) {
		boardservice.update(boardContent, boardId);
//		System.out.println(boardContent+","+boardId);
		return "redirect:/main.do";
	}
	
	@RequestMapping("/board/exp.do")
	public String expPage() {
		return "main/instagram_exploration";
	}
}
