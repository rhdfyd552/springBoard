package kr.or.ddit.file;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import kr.or.ddit.file.dao.FileDaoInf;
import kr.or.ddit.file.model.FileVo;
import kr.or.ddit.spring.test.TestInit;

import org.junit.Test;

public class FileDaoTest extends TestInit{
	@Resource(name="fileDao")
	FileDaoInf fileDao;

	@Test
	public void test() {
		/***Given***/
		FileVo fileVo = new FileVo();

		/***When***/
		fileVo.setFi_board_seq(146);
		fileVo.setFi_name("test");
		fileVo.setFi_path("/upload");
		
		int cnt = fileDao.insertFile(fileVo);
		/***Then***/
		assertEquals(1, cnt);

	}

}
