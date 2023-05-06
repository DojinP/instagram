package com.multi.instagram.follow;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.multi.instagram.member.MemberDTO;
import com.multi.instagram.member.MemberService;

@Controller
public class FollowController {
	@Autowired
	FollowService service;
	@Autowired
	MemberService memberserivce;
	//팔로우하기
	@RequestMapping("/follow/connectFollow.do")
	public String connectFollow(String following_id, HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("loginUser");
		String follower_id = member.getId();
		int result = service.connectFollow(follower_id, following_id);
		
		if (result == 1) {
			return "redirect:/myprofile?pageType=user&member_id=" + following_id;
		} else {
			return "redirect:/main.do";
		}
	}
	//팔로우리스트
	@RequestMapping("/open_follow_popup.do")
	public ModelAndView followlist(String member_id, String pageType) {
		ModelAndView mav = new ModelAndView("follow/instagram_follow_popup");
		List<FollowDTO> followlist = service.getFollowList(member_id);	
		List<MemberDTO> memberlist =  memberserivce.member_list();
		mav.addObject("followlist",followlist);
		mav.addObject("pageType", pageType);
		mav.addObject("member_id", member_id);
		mav.addObject("memberlist", memberlist);

		return mav;
	}
	//팔로워리스트
	@RequestMapping("/open_follower_popup.do")
	public ModelAndView followerlist(String member_id, String pageType) {
		ModelAndView mav = new ModelAndView("follow/instagram_follower_popup");
		List<FollowDTO> followerlist = service.getFollowerList(member_id);
		List<MemberDTO> memberlist =  memberserivce.member_list();
		mav.addObject("followerlist",followerlist);
		mav.addObject("pageType", pageType);
		mav.addObject("member_id", member_id);
		mav.addObject("memberlist", memberlist);


		return mav;
	}
	//팔로우끊기
	@RequestMapping("/follow/disconnectFollow.do")
	public String disconnectFollow(String follow_id, String pageType, String member_id) {
		int result = service.disconnectFollow(follow_id);
		if (result == 1) {
			String redirectUrl = "redirect:/myprofile?pageType=" + pageType;
			if (pageType.equals("user")) {
				redirectUrl += "&member_id=" + member_id;
			}
			return redirectUrl;
		} else {
			// 오류 페이지로 가야하지만 없으니 main
			return "redirect:/main.do";
		}
	}
	
	@RequestMapping("/myprofile")
	public ModelAndView myprofile(HttpServletRequest request, String pageType, String member_id) {
		ModelAndView mav = new ModelAndView("follow/instagram_profile");
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("loginUser");		
		if (pageType.equals("user")) {
			member = service.getMember(member_id);
		}
		
		int followCount = service.getFollowCount(member.getId());
		int followerCount = service.getFollowerCount(member.getId());
		
		mav.addObject("member", member);
		mav.addObject("followingCount",followCount);
		mav.addObject("followerCount", followerCount);
		mav.addObject("pageType", pageType);
		//팝업 open할 페이지 구분하기 위해 type도 전송
		return mav;
	}
	
}

