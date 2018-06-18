package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import kr.or.ddit.member.dao.MemberDaoInf;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.spring.test.TestInit;

import org.junit.Test;

import util.KISA_SHA256;

public class MemberServiceTest extends TestInit{
	@Resource(name="memberService")
	private MemberServiceInf memberService;
	
	@Test
	public void getMemberTest() {
		/***Given***/
		MemberVo memberVo = new MemberVo();
		memberVo.setMem_id("sally");
		memberVo.setMem_pass("1234");

		/***When***/
		MemberVo login = memberService.loginMember(memberVo);
		String pass = KISA_SHA256.encrypt(memberVo.getMem_pass());

		/***Then***/
		assertEquals("3ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4", login.getMem_pass());


	}

}
