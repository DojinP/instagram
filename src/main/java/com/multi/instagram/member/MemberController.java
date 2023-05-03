package com.multi.instagram.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
		
		String rediPath = "main.do";
		String alertMsg = "로그아웃 되었습니다.";
		String view = "main/instagram_popup_alert";
		
		mav.addObject("alertMsg", alertMsg);
		mav.addObject("rediPath", rediPath);
		mav.setViewName(view);
		
		return mav;
	}
	

}
