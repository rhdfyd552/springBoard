package kr.or.ddit.member.service;


import javax.annotation.Resource;

import kr.or.ddit.member.dao.MemberDaoInf;
import kr.or.ddit.member.model.MemberVo;

import org.springframework.stereotype.Service;

import util.KISA_SHA256;

@Service("memberService")
public class MemberServiceImpl implements MemberServiceInf{
	@Resource(name="memberDao")
	private MemberDaoInf memberDao;
	
	@Override
	public MemberVo loginMember(MemberVo memberVo) {
		String pass = memberVo.getMem_pass();
		String encrypt = KISA_SHA256.encrypt(pass);
		memberVo.setMem_pass(encrypt);
		return memberDao.getMember(memberVo);
	}

}
