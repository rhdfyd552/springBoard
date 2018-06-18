package kr.or.ddit.board.model;

import java.util.Date;

import javax.servlet.jsp.PageContext;

public class BoardVo {
	private int board_seq;
	private int pboard_seq;
	private int category_seq;
	private int group_seq;
	private String title;
	private String content;
	private String reg_id;
	private Date reg_dt;
	private String del_yn;
	
	public BoardVo() {
		// TODO Auto-generated constructor stub
	}

	public BoardVo(int board_seq, int pboard_seq, int category_seq,
			int group_seq, String title, String content, String reg_id) {
		this.board_seq = board_seq;
		this.pboard_seq = pboard_seq;
		this.category_seq = category_seq;
		this.group_seq = group_seq;
		this.title = title;
		this.content = content;
		this.reg_id = reg_id;
	}

	public int getBoard_seq() {
		return board_seq;
	}

	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}

	public int getPboard_seq() {
		return pboard_seq;
	}

	public void setPboard_seq(int pboard_seq) {
		this.pboard_seq = pboard_seq;
	}

	public int getCategory_seq() {
		return category_seq;
	}

	public void setCategory_seq(int category_seq) {
		this.category_seq = category_seq;
	}

	public int getGroup_seq() {
		return group_seq;
	}

	public void setGroup_seq(int group_seq) {
		this.group_seq = group_seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReg_id() {
		return reg_id;
	}

	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}

	public Date getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}

	public String getDel_yn() {
		return del_yn;
	}

	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}
	

	public static String makePageNav(int page, int totalBoard) {
		
		StringBuffer pageNav = new StringBuffer();
		
		int pageTotal = (int)Math.ceil((double)totalBoard/10);
		pageNav.append("<nav id='nav'>");
		pageNav.append("	<ul class='pagination'>");
		pageNav.append("		<li>");
		if(page>1 || page-1>0){
				pageNav.append("<a href='boardList?page=1&pageSize=10' aria-label='Previous'>");
				pageNav.append("<span aria-hidden='true'>&laquo;</span></a></li>");
				pageNav.append("<li><a href='boardList?page="+(page-1)+"&pageSize=10' aria-label='Previous'>");
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
				pageNav.append("<li class='active'><a href='boardList?page="+i+"&pageSize=10'>"+i+"</a>");
			}else {
				pageNav.append("<li><a href='boardList?page="+i+"&pageSize=10'>"+i+"</a></li>");
			}	
		}
		if(page+1<pageTotal+1 || page != pageTotal){
			pageNav.append("<li><a href='boardList?page="+(page+1)+"&pageSize=10'>");
			pageNav.append("<span aria-hidden='true'>&gt;</span></a></li>");
			pageNav.append("<li><a href='boardList?page="+pageTotal+"&pageSize=10' aria-label='Next'>");
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

	public static String makeSelPageNav(Integer notice, Integer page,
			int countBoard) {
StringBuffer pageNav = new StringBuffer();
		
		int pageTotal = (int)Math.ceil((double)countBoard/10);
		pageNav.append("<nav id='nav'>");
		pageNav.append("	<ul class='pagination'>");
		pageNav.append("		<li>");
		if(page>1 || page-1>0){
				pageNav.append("<a href='boardList?no_seq="+notice+"&page=1&pageSize=10' aria-label='Previous'>");
				pageNav.append("<span aria-hidden='true'>&laquo;</span></a></li>");
				pageNav.append("<li><a href='boardList?no_seq="+notice+"&page="+(page-1)+"&pageSize=10' aria-label='Previous'>");
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
				pageNav.append("<li class='active'><a href='boardList?no_seq="+notice+"&page="+i+"&pageSize=10'>"+i+"</a>");
			}else {
				pageNav.append("<li><a href='boardList?no_seq="+notice+"&page="+i+"&pageSize=10'>"+i+"</a></li>");
			}	
		}
		if(page+1<pageTotal+1 || page != pageTotal){
			pageNav.append("<li><a href='boardList?no_seq="+notice+"&page="+(page+1)+"&pageSize=10'>");
			pageNav.append("<span aria-hidden='true'>&gt;</span></a></li>");
			pageNav.append("<li><a href='boardList?no_seq="+notice+"&page="+pageTotal+"&pageSize=10' aria-label='Next'>");
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
