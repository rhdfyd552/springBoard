package kr.or.ddit.notice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.notice.dao.NoticeDaoInf;
import kr.or.ddit.notice.model.NoticeVo;

import org.springframework.stereotype.Service;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeServiceInf{
	@Resource(name="noticeDao")
	private NoticeDaoInf noticeDao;
	
	@Override
	public List<NoticeVo> noticeList() {
		return noticeDao.noticeList();
	}

	@Override
	public Map<String, Object> allNoticeList(Map<String, Integer> map) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<NoticeVo>noticeList = noticeDao.allNoticeList(map);
		String pageNav = NoticeVo.noticeMakePageNav(map.get("page"), noticeDao.countNotice());
		
		resultMap.put("allNoticeList", noticeList);
		resultMap.put("noPageNav", pageNav);
		
		return resultMap;
	}

	@Override
	public int disabledNotice(NoticeVo noticeVo) {
		return noticeDao.disabledNotice(noticeVo);
		
	}

	@Override
	public String noticeName(int category_seq) {
		return noticeDao.noticeNanem(category_seq);
	}

	@Override
	public int insertNotice(NoticeVo notice) {
		return noticeDao.insertNotice(notice);
	}
}
