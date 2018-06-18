package kr.or.ddit.member.dao;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.member.model.MemberVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDaoInf{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public MemberVo getMember(MemberVo memberVo) {
		return sqlSessionTemplate.selectOne("member.getMember",memberVo);
	}
	
	

}
