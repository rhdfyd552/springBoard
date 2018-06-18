package kr.or.ddit.notice.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.notice.model.NoticeVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("noticeDao")
public class NoticeDaoImpl implements NoticeDaoInf{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<NoticeVo> noticeList() {
		return sqlSessionTemplate.selectList("notice.noticeList");
	}

	@Override
	public List<NoticeVo> allNoticeList(Map<String, Integer> map) {
		return sqlSessionTemplate.selectList("notice.allNoticeList",map);
	}

	@Override
	public int countNotice() {
		return sqlSessionTemplate.selectOne("notice.countNotice");
	}

	@Override
	public int disabledNotice(NoticeVo noticeVo) {
		return sqlSessionTemplate.update("notice.disabledNotice",noticeVo);
		
	}

	@Override
	public String noticeNanem(int category_seq) {
		return sqlSessionTemplate.selectOne("notice.noticeName",category_seq);
	}

	@Override
	public int insertNotice(NoticeVo notice) {
		return sqlSessionTemplate.insert("notice.insertNotice",notice);
	}
	
	
}
