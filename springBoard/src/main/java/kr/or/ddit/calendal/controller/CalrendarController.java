package kr.or.ddit.calendal.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.calendal.model.CalendarVo;
import kr.or.ddit.calendal.service.CalrendarServiceInf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/main")
@Controller
public class CalrendarController {
	Logger logger = LoggerFactory.getLogger(CalrendarController.class);
	
	@Resource(name="calService")
	private CalrendarServiceInf calService;
	
	@RequestMapping("/calendar")
	public String hoem(Model model){
		List<CalendarVo>list = calService.getList();
		model.addAttribute("calList", list);
		
		return "main/calendar";
	}
	
	@RequestMapping("/setCalendar")
	public String setCalendar(int time){
		
		calService.setCalendar(time);
		return "redirect:/main/calendar";
	}
}
