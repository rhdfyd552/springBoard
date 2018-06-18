package kr.or.ddit.notice.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.notice.model.NoticeVo;
import kr.or.ddit.spring.test.TestInit;

import org.junit.Test;

public class NoticeDaoTest extends TestInit{
	@Resource(name="noticeDao")
	private NoticeDaoInf noticeDao;
	
	@Test
	public void allNoticeTest() {
		/***Given***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", 1);
		map.put("pageSize", 10);
		

		/***When***/
		List<NoticeVo> nolist = noticeDao.allNoticeList(map);

		/***Then***/
		assertEquals(10, nolist.size());

	}

}
