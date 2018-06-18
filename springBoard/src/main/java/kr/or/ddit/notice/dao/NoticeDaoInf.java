package kr.or.ddit.notice.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.notice.model.NoticeVo;

public interface NoticeDaoInf {
	public List<NoticeVo> noticeList();
	
	public List<NoticeVo> allNoticeList(Map<String, Integer>map);
	
	public int countNotice();
	
	public int disabledNotice(NoticeVo noticeVo);

	public String noticeNanem(int category_seq);

	public int insertNotice(NoticeVo notice);
}
