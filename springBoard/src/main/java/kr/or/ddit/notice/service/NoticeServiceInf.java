package kr.or.ddit.notice.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.notice.model.NoticeVo;

public interface NoticeServiceInf {
	public List<NoticeVo> noticeList();

	public Map<String, Object> allNoticeList(Map<String, Integer>map);
	
	public int disabledNotice(NoticeVo noticeVo);

	public String noticeName(int category_seq);

	public int insertNotice(NoticeVo notice);
}
