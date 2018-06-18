package kr.or.ddit.notice.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.notice.dao.NoticeDaoInf;
import kr.or.ddit.notice.model.NoticeVo;
import kr.or.ddit.spring.test.TestInit;

import org.junit.Test;

public class NoticeServiceTest extends TestInit{
	@Resource(name="noticeService")
	private NoticeServiceInf noticeService;
	
	@Test
	public void allNoticeTest() {
		/***Given***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", 1);
		map.put("pageSize", 10);
		

		/***When***/
		Map<String, Object> resultMap = noticeService.allNoticeList(map);
		List<NoticeVo>nolist = (List<NoticeVo>) resultMap.get("allNoticeList");
		/***Then***/
		assertEquals(10, nolist.size());

	}
}
