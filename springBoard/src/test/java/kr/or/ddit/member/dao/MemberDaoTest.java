package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.spring.test.TestInit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


public class MemberDaoTest extends TestInit{
	@Resource(name="memberDao")
	private MemberDaoInf memberDao;
	
	
	@Test
	public void getMemberTest() {
		/***Given***/
		MemberVo memberVo = new MemberVo();
		memberVo.setMem_id("test");
		memberVo.setMem_pass("2222");

		/***When***/
		MemberVo login = memberDao.getMember(memberVo);

		/***Then***/
		assertEquals("tester", login.getMem_name());

	}

}
