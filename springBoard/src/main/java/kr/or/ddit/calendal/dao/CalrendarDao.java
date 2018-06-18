package kr.or.ddit.calendal.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.calendal.model.CalendarVo;

@Repository("calDao")
public class CalrendarDao implements CalrendarDaoInf{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<CalendarVo> getList() {	
		return sqlSessionTemplate.selectList("calendar.getCalendar");
	}

	@Override
	public int setCalendar(CalendarVo calendarVo) {
		return sqlSessionTemplate.insert("calendar.setCalendar",calendarVo);
	}

	@Override
	public CalendarVo getCalendar(String cal_mem_id) {
		return sqlSessionTemplate.selectOne("calendar.getMemberTime", cal_mem_id);
	}

	@Override
	public int updateCalendar(CalendarVo calendarVo) {
		return sqlSessionTemplate.update("calendar.updateCalendar",calendarVo);
	}
	
	
}
