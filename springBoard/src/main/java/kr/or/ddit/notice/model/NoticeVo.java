package kr.or.ddit.notice.model;

import java.util.Date;

public class NoticeVo {
	private Integer no_seq;
	private String no_mem_id;
	private String no_name;
	private String no_st;
	private Date no_dt;
	
	public NoticeVo() {
	}
	
	

	public NoticeVo(String no_mem_id, String no_name,
			String no_st) {
		this.no_mem_id = no_mem_id;
		this.no_name = no_name;
		this.no_st = no_st;
	}



	public Integer getNo_seq() {
		return no_seq;
	}

	public void setNo_seq(Integer no_seq) {
		this.no_seq = no_seq;
	}

	public String getNo_mem_id() {
		return no_mem_id;
	}

	public void setNo_mem_id(String no_mem_id) {
		this.no_mem_id = no_mem_id;
	}

	public String getNo_name() {
		return no_name;
	}

	public void setNo_name(String no_name) {
		this.no_name = no_name;
	}

	public String getNo_st() {
		return no_st;
	}

	public void setNo_st(String no_st) {
		this.no_st = no_st;
	}

	public Date getNo_dt() {
		return no_dt;
	}

	public void setNo_dt(Date no_dt) {
		this.no_dt = no_dt;
	}

	@Override
	public String toString() {
		return "NoticeVO [no_seq=" + no_seq + ", no_mem_id=" + no_mem_id
				+ ", no_name=" + no_name + ", no_st=" + no_st + ", no_dt="
				+ no_dt + "]";
	}
	
	public static String noticeMakePageNav(int page, int totalBoard) {
		
		StringBuffer pageNav = new StringBuffer();
		
		int pageTotal = (int)Math.ceil((double)totalBoard/10);
		pageNav.append("<nav id='nav'>");
		pageNav.append("	<ul class='pagination'>");
		pageNav.append("		<li>");
		if(page>1 || page-1>0){
				pageNav.append("<a href='noticeList?page=1&pageSize=10' aria-label='Previous'>");
				pageNav.append("<span aria-hidden='true'>&laquo;</span></a></li>");
				pageNav.append("<li><a href='noticeList?page="+(page-1)+"&pageSize=10' aria-label='Previous'>");
				pageNav.append("<span aria-hidden='true'>&lt;</span>");
		}else{
			pageNav.append("<a href='#' aria-label='Previous'>");
			pageNav.append("<span aria-hidden='true'>&laquo;</span></a></li>");
			pageNav.append("<li><a href='#' aria-label='Previous'>");
			pageNav.append("<span aria-hidden='true'>&lt;</span>");
		}
		
		pageNav.append("	</a></li>");
		
		for(int i = 1;i<=pageTotal; i++){
			if(i==page){
				pageNav.append("<li class='active'><a href='noticeList?page="+i+"&pageSize=10'>"+i+"</a>");
			}else {
				pageNav.append("<li><a href='noticeList?page="+i+"&pageSize=10'>"+i+"</a></li>");
			}	
		}
		if(page+1<pageTotal+1 || page != pageTotal){
			pageNav.append("<li><a href='noticeList?page="+(page+1)+"&pageSize=10'>");
			pageNav.append("<span aria-hidden='true'>&gt;</span></a></li>");
			pageNav.append("<li><a href='noticeList?page="+pageTotal+"&pageSize=10' aria-label='Next'>");
			pageNav.append("<stan aria-hidden='true'>&raquo;</span>");	
		}else{
			pageNav.append("<li><a href='#>");
			pageNav.append("<span aria-hidden='true'>&gt;</span></a></li>");
			pageNav.append("<li><a href='#' aria-label='Next'>");
			pageNav.append("<stan aria-hidden='true'>&raquo;</span>");
		}
		
		pageNav.append("</a></li>");
		pageNav.append("</ul>");
		pageNav.append("</nav>");
		return pageNav.toString();
	}
	
}
