package com.multi.instagram.dm;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.multi.instagram.member.MemberDTO;
import com.mysql.cj.Session;

@Controller
public class DMController {
	@Autowired
	DMservice dmservice;
	@Autowired
	dm_chatroomService chatservice;
	@RequestMapping("/dm.insta")
	public ModelAndView dm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main/Instagram_DM");
		return mav;	
	}
	
	@RequestMapping(value = "/list.do",produces = "application/json;charset=utf-8")
	@ResponseBody
	public List<MemberDTO> userList(String member_id) {
		List<MemberDTO> user = dmservice.listuser(member_id);
		return user;
	}
	
	@RequestMapping(value = "/boardlist.do",produces = "application/json;charset=utf-8")
	@ResponseBody
	public List<DMDTO> boardList( HttpSession session) {
		MemberDTO member = (MemberDTO)session.getAttribute("loginUser");
		int sender = Integer.parseInt(member.getId());
		List<DMDTO> board = dmservice.boardlist(sender);
		return board;
	}
	
	@RequestMapping("/createboard.do")
	public String insert(HttpSession session,@RequestParam("opponent")int opponent) { 
		MemberDTO member = (MemberDTO)session.getAttribute("loginUser");
		int sender = Integer.parseInt(member.getId());
		System.out.println(sender);
		System.out.println(opponent);
		dmservice.insert(sender, opponent);
		return "redirect:/main/Instagram_DM";
	}
	
	@RequestMapping(value = "/chatlist.do",produces = "application/json;charset=utf-8")
	@ResponseBody
	public List<dm_chatroomDTO> chatlist(@RequestParam("dmId")int dmid) {
		List<dm_chatroomDTO> chatlist = chatservice.listchat(dmid);
		return chatlist;
	}
	
	@RequestMapping(value = "/chatinsert.do",produces = "application/json;charset=utf-8")
	@ResponseBody
	public String chatinsert(@RequestParam("dmId")int dmId, @RequestParam("message_content")String content) {// HttpSession session
		//MemberDTO member = (MemberDTO)session.getAttribute("loginUser");
		//String sender = member.getId();
		System.out.println(dmId+" // "+content);
		String sender = "1";
		chatservice.insert(dmId, sender, content);
		System.out.println(dmId);
		return "/chatlist.do";
	}
	
	
}
