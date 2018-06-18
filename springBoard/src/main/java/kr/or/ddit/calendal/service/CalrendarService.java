package kr.or.ddit.calendal.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.calendal.dao.CalrendarDaoInf;
import kr.or.ddit.calendal.model.CalendarVo;

import org.springframework.stereotype.Service;

@Service("calService")
public class CalrendarService implements CalrendarServiceInf{
	@Resource(name="calDao")
	private CalrendarDaoInf calDao;

	@Override
	public List<CalendarVo> getList() {
		
		return calDao.getList();
	}

	@Override
	public int setCalendar(int time) {
		
		CalendarVo vo = calDao.getCalendar("홍길동");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		Date date = new Date();
		
		int endTime = 20180605;
		int currTime = Integer.parseInt(sdf.format(date));
		int resultTime = endTime-currTime;
		
		Calendar cal = Calendar.getInstance();
		
		CalendarVo calendarVo = new CalendarVo();
		if(resultTime<=0){
			calendarVo.setCal_start_time(sdf.format(date));
			cal.setTime(date);
			cal.add(cal.DATE, time);
			calendarVo.setCal_end_time(sdf.format(cal.getTime()));
			calendarVo.setCal_mem_id("홍길동");
			calendarVo.setCal_title("insert연습");
			return calDao.setCalendar(calendarVo);
			
		}else{
			Date endDay=null;
			try {
				endDay = sdf.parse(vo.getCal_end_time());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			cal.setTime(endDay);
			cal.add(cal.DATE, time);
			calendarVo.setCal_end_time(sdf.format(cal.getTime()));
			calendarVo.setCal_mem_id("cony");
			System.out.println(sdf.format(cal.getTime()));
			return calDao.updateCalendar(calendarVo);
		}
		
	}

	@Override
	public CalendarVo getCalendar(String cal_mem_id) {
		return calDao.getCalendar(cal_mem_id);
	}
	
	
	
}
