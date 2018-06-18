package kr.or.ddit.calendal.dao;

import java.util.List;

import kr.or.ddit.calendal.model.CalendarVo;

public interface CalrendarDaoInf {
	public List<CalendarVo> getList();
	
	public int setCalendar(CalendarVo calendarVo);
	
	public int updateCalendar(CalendarVo calendarVo);
	
	public CalendarVo getCalendar(String cal_mem_id);
}
