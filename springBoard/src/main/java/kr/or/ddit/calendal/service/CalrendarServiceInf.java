package kr.or.ddit.calendal.service;

import java.util.List;

import kr.or.ddit.calendal.model.CalendarVo;

public interface CalrendarServiceInf {
	public List<CalendarVo> getList();
	
	public int setCalendar(int time);
	
	public CalendarVo getCalendar(String cal_mem_id);

}
