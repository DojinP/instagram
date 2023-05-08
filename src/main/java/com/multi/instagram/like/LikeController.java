package com.multi.instagram.like;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.multi.instagram.board.BoardAbstractService;
import com.multi.instagram.board.BoardDTO;
import com.multi.instagram.board.BoardFileDTO;
import com.multi.instagram.member.MemberDTO;
import com.multi.instagram.member.MemberService;

@Controller
public class LikeController {
	@Autowired
	LikeServiceImpl service;
	@Autowired
	BoardAbstractService boardservice;

	@Autowired
	MemberService memberserivce;

	// 추가
	@RequestMapping("/like.do")
	public ModelAndView likePage(HttpSession session) {

		MemberDTO memberDto = (MemberDTO) session.getAttribute("loginUser");
		int userId = Integer.parseInt(memberDto.getId());

		List<LikeDTO> likelist = service.select_like_user(userId);
		ModelAndView mav = new ModelAndView("like/instagram_post_like");

		for (LikeDTO dto : likelist) {
			int boardId = dto.getBoardId();
			List<BoardFileDTO> boardfilelist = boardservice.selectLikeFile(boardId);
			if (boardfilelist.size() != 0) {
				dto.setStoreFilename(boardfilelist.get(0).getStoreFilename());
			}
		}

		mav.addObject("likelist", likelist);
		return mav;

	}

	@RequestMapping("/instagram_post_like")
	public ModelAndView showPage(int userid) {
		List<BoardDTO> output = service.Like_List(userid);
		System.out.println(output);
		ModelAndView mav = new ModelAndView("main/instagram_post_like");
		mav.addObject("output", output);
		return mav;
	}

	public int count(String likeId) {
		int cnt = service.count(likeId);
		return cnt;
	}

	@RequestMapping("/like_insert.do")
	public ModelAndView like_insert(int boardId, int userId) {
		ModelAndView mav = new ModelAndView("main/instagram_popup_alert");
		List<LikeDTO> count = service.select(boardId, userId);
		String rediPath = ""; // 리디렉션 path
		String alertMsg = ""; // 성공 여부 메시지 저장

		if (count.size() > 0) {
			rediPath = "/instagram/main.do";
			alertMsg = "이미 좋아요를 누른 게시물 입니다.";

		} else {

			int result = service.insert(boardId, userId);

			rediPath = "/instagram/main.do";
			alertMsg = "좋아요를 눌렀습니다. ";

		}

		mav.addObject("alertMsg", alertMsg);
		mav.addObject("rediPath", rediPath);
		return mav;

	}

//	//빈 하트 클릭 시 하트 저장
//	@ResponseBody
//	@RequestMapping(value="/saveHeart.do")
//	public HeartDTO save_heart (@RequestParam String no, HttpSession session) {
//		LikeDTO dto = new LikeDTO();
//		
//		
//	}

	/*
	 * @RequestMapping("/like.do") public ModelAndView read(String userId) {
	 * ModelAndView mav = new ModelAndView(); List<BoardDTO> likelist =
	 * service.read(userId); mav.addObject("likelist", likelist);
	 * mav.addObject("userId", userId); return mav; }
	 */

	/*
	 * @RequestMapping("/like.do") public ModelAndView likePage(String like) {
	 * ModelAndView mav = new ModelAndView("main/instagram_post_like");
	 * List<LikeDTO> likelist = service.select(); System.out.println(likelist);
	 * mav.addObject("likelist", likelist);//object는 맵 형식으로 저장됨 return mav; }
	 */
	/*
	 * @RequestMapping("/likedelete.do") public String delete(String likeId) {
	 * service.delete(likeId); return "redirect:/like.do"; }
	 * 
	 * @RequestMapping("/likeread.do") public ModelAndView read(String likeId,
	 * String state) { ModelAndView mav = new ModelAndView(); //서비스 메소드 호출
	 * System.out.println(likeId); LikeDTO like = service.read(likeId); //데이터 공유
	 * mav.addObject("like",like); //뷰 정보 세팅 String view="";
	 * if(state.equals("READ")) { view="instagram_post_like"; }else {
	 * view="instargram_main_page"; } mav.setViewName(view); return mav; }
	 */
}
