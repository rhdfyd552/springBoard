package kr.or.ddit.login.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.service.MemberServiceInf;


import kr.or.ddit.notice.model.NoticeVo;
import kr.or.ddit.notice.service.NoticeServiceInf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/")
@Controller
public class LoginController {
	@Resource(name="memberService")
	private MemberServiceInf memberService;
	
	@Resource(name="noticeService")
	private NoticeServiceInf noticeService;
	
	@Resource(name="boardService")
	private BoardServiceInf boardService;
	
	@ModelAttribute
	public void noticeList(HttpSession session, HttpServletRequest request){
		List<NoticeVo>noticeList = noticeService.noticeList();

		
		session.setAttribute("noticeList", noticeList);
	
	}
	
	
	@RequestMapping("/login")
	public String login(){
		return "login/login";
	}
	
	@RequestMapping(value="/loginMav", method=RequestMethod.POST)
	public String loginMav(HttpSession session,MemberVo memberVo){
		MemberVo loginUser = memberService.loginMember(memberVo);
		if(loginUser != null){
			session.setAttribute("loginUser", loginUser.getMem_id());
			return "redirect:/boardList?page=1&pageSize=10";
		}else {
			return "redirect:/login";			
		}
	}
	
	@RequestMapping(value="/boardList",method=RequestMethod.GET ,params={"page","pageSize"})
	public String board(HttpServletRequest request){
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", Integer.parseInt(request.getParameter("page")));
		map.put("pageSize", 10);
		
		
		Map<String, Object>page = boardService.allBoardList(map);
		List<BoardVo>boardList = (List<BoardVo>)page.get("boardList");
		for(BoardVo boardVo : boardList){
			boardVo.setTitle(boardVo.getTitle().replace(" ", "&nbsp"));
		}
		
		request.setAttribute("pageNav", page.get("pageNav"));
		request.setAttribute("boardList", boardList);
		return "board/main/boardList";
	}
	
	
	
}
