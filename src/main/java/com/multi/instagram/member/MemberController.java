package com.multi.instagram.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	@Autowired
	MemberService service;

	// 메인 페이지 출력 (임시)
	@RequestMapping(value = "/index.html")
	public String home() {
		return "main/index";
	}
	
	// 회원가입 페이지 출력
	@RequestMapping("/view/signup")
	public String showSignup() {
		return "member/instagram_signup";
	}
	
	// 로그인 페이지 출력
	@RequestMapping("/view/login")
	public String showLogin() {
		return "member/instagram_login";
	}
	
	// 프로필 변경 페이지 출력
	@RequestMapping("/member/update")
	public String showProfile() {
		return "member/instagram_profile_update";
	}
	
	// 회원가입 메소드
	@RequestMapping("/signup.do")
	public ModelAndView signup(MemberDTO member) {
		System.out.println("회원가입 시행 - Controller");
		ModelAndView mav = new ModelAndView("main/instagram_popup_alert");
		String rediPath = "";	// 리디렉션 path
		String alertMsg = "";	// 성공 여부 메시지 저장
		int res = service.signup(member);
		if(res > 0) {
			rediPath = "view/login";
			alertMsg = "가입 성공";
		}else {
			rediPath = "view/signup";	// ~/instagram/'view/signup'
			alertMsg = "가입 실패";
		}
		
		mav.addObject("alertMsg", alertMsg);
		mav.addObject("rediPath", rediPath);
		
		return mav;
	}
	
	// 로그인 메소드
	@RequestMapping("/login.do")
	public ModelAndView login(HttpServletRequest request, MemberDTO member){
		ModelAndView mav = new ModelAndView();
		MemberDTO loginUser = service.login(member);
		String rediPath = "";
		String view = "main/instagram_popup_alert";
		String alertMsg = "";
		
		if(loginUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			rediPath = "main.do";
//			rediPath = "index.html"; // 테스트용
			alertMsg = "로그인 성공";
		}else {
			rediPath = "view/login";
			alertMsg = "로그인 실패";
		}
		
		mav.addObject("alertMsg", alertMsg);
		mav.addObject("rediPath", rediPath);
		
		mav.setViewName(view);
		return mav;
	}
	
	// 로그아웃 메소드
	@RequestMapping("/logout.do")
	public ModelAndView logout(HttpSession session) {
		if(session != null) {
			session.invalidate();
		}
		
		ModelAndView mav = new ModelAndView();
		
		String rediPath = "/instagram/view/login";
		String alertMsg = "로그아웃 되었습니다.";
		String view = "main/instagram_popup_alert";
		
		mav.addObject("alertMsg", alertMsg);
		mav.addObject("rediPath", rediPath);
		mav.setViewName(view);
		
		return mav;
	}
	
	// 회원수정 메소드
	@RequestMapping("/member/update.do")
	public ModelAndView update(MemberDTO member) {
		ModelAndView mav = new ModelAndView();
		
		String rediPath = "";
		String alertMsg = "";
		String view = "main/instagram_popup_alert";
		
		System.out.println(member.toString());
		
		int res = service.update(member);
		if(res > 0) {
			// 프로필 보기 페이지로 이동
			rediPath = "/instagram/main.do";
			alertMsg = "회원정보가 수정되었습니다.";
		}else {
			// 제자리로 이동
			rediPath = "/instagram/profile/update";
			alertMsg = "회원정보 수정에 실패하였습니다.";
		}
		
		mav.addObject("alertMsg", alertMsg);
		mav.addObject("rediPath", rediPath);
		mav.setViewName(view);
		
		return mav;
	}
	
	// 회원탈퇴 메소드
	@RequestMapping("/member/delete.do")
	public ModelAndView delete(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		String rediPath = "";
		String alertMsg = "";
		String view = "main/instagram_popup_alert";
		
		mav.setViewName(view);
		
		// 세션 없이 접근한 경우
		if(session == null) {
			rediPath = "/instagram/view/login";
			alertMsg = "잘못된 접근입니다.";
			
			mav.addObject("alertMsg", alertMsg);
			mav.addObject("rediPath", rediPath);
			
			return mav;
		}
		
		MemberDTO member = (MemberDTO)session.getAttribute("loginUser");
		
		int res = service.delete(member);
		if(res > 0) {
			// 메인 페이지로 이동
			rediPath = "/instagram/main.do";
			alertMsg = "정상적으로 탈퇴 처리되었습니다.";
			// 세션 삭제
			session.invalidate();
		}else {
			// 제자리로 이동
			rediPath = "/instagram/index.html";
			alertMsg = "회원 탈퇴에 실패하였습니다.";
		}
		
		mav.addObject("alertMsg", alertMsg);
		mav.addObject("rediPath", rediPath);
		
		return mav;
	}
	
	//유세희 - 추가 멤버 nickname 가져오는 컨트롤러 추가
	@RequestMapping(value = "/member/nickname.do", produces = "application/text;charset=utf-8")
	@ResponseBody
	public String nickname(String member_id) {
		System.out.println("member_nick"+member_id);
		String nickname = service.member_nick(member_id);
		System.out.println("member_nick"+nickname);
		return nickname;
	}
}
