package kr.or.ddit.notice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.notice.model.NoticeVo;
import kr.or.ddit.notice.service.NoticeServiceInf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/notice")
@Controller
public class NoticeCotroller {
	Logger logger = LoggerFactory.getLogger(NoticeCotroller.class);
	
	@Resource(name="noticeService")
	private NoticeServiceInf noticeService;
	
	
	
	
	@RequestMapping(value="/noticeList",method=RequestMethod.GET, params={"page","pageSize"})
	public String adminPage(HttpServletRequest request){
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", Integer.parseInt(request.getParameter("page")));
		map.put("pageSize", 10);
		
		
		Map<String, Object>page = noticeService.allNoticeList(map);
		List<NoticeVo>noticeList = (List<NoticeVo>)page.get("allNoticeList");
		
		request.setAttribute("noPageNav", page.get("noPageNav"));
		request.setAttribute("allNoticeList", noticeList);
		return "board/notice/noticeList";
		
	}
	
	@RequestMapping(value="/disabledNotice",method=RequestMethod.POST)
	public String disabledNotice(HttpServletRequest request,HttpSession session){
		String no_st = request.getParameter("checkDisabled");
		
		int no_seq = Integer.parseInt(request.getParameter("no_seq"));
		
		NoticeVo notice = new NoticeVo();
		notice.setNo_seq(no_seq);
		notice.setNo_st(no_st);
		int cnt = noticeService.disabledNotice(notice);
		logger.debug("{}",cnt+"==================================");
		List<NoticeVo>noticeList = noticeService.noticeList();
		session.setAttribute("noticeList", noticeList);
		
		return "redirect:noticeList?page=1&pageSize=10";
	}
	
	@RequestMapping("/noticeForm")
	public String noticeForm(){
		return "board/notice/noticeForm";
	}
	
	@RequestMapping("/insertNotice")
	public String insertNotice(String no_name,String no_mem_id){
		
		NoticeVo notice = new NoticeVo();
		notice.setNo_mem_id(no_mem_id);
		notice.setNo_name(no_name);
		int cnt = noticeService.insertNotice(notice);
		
		if(cnt == 1){
			return "redirect:/notice/noticeList?page=1&pageSize=10";
		}else{
			return "board/notice/noticeForm";
		}
	}
}
