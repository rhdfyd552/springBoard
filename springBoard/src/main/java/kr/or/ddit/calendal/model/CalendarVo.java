package kr.or.ddit.calendal.model;

import java.util.Date;


public class CalendarVo {
	private Integer cal_id;
	private String cal_mem_id;
	private String cal_title;
	private String cal_start_time;
	private String cal_end_time;
	
	
	public CalendarVo() {
		// TODO Auto-generated constructor stub
	}
	
	public int getCal_id() {
		return cal_id;
	}
	
	public void setCal_id(int cal_id) {
		this.cal_id = cal_id;
	}
	
	public String getCal_mem_id() {
		return cal_mem_id;
	}
	public void setCal_mem_id(String cal_mem_id) {
		this.cal_mem_id = cal_mem_id;
	}
	public String getCal_title() {
		return cal_title;
	}
	public void setCal_title(String cal_title) {
		this.cal_title = cal_title;
	}
	public String getCal_start_time() {
		return cal_start_time;
	}
	public void setCal_start_time(String cal_start_time) {
		this.cal_start_time = cal_start_time;
	}
	public String getCal_end_time() {
		return cal_end_time;
	}
	public void setCal_end_time(String cal_end_time) {
		this.cal_end_time = cal_end_time;
	}


	
	
}
