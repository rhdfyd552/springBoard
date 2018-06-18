package kr.or.ddit.file;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import kr.or.ddit.file.model.FileVo;
import kr.or.ddit.file.service.FileServiceInf;
import kr.or.ddit.spring.test.TestInit;

import org.junit.Test;

public class FileServiceTest extends TestInit{
	@Resource(name="fileService")
	FileServiceInf fileService;
	
	@Test
	public void test() {
		/***Given***/
		FileVo fileVo = new FileVo();

		/***When***/
		fileVo.setFi_board_seq(146);
		fileVo.setFi_name("test");
		fileVo.setFi_path("/upload");
		
		//int cnt = fileService.insertFile(fileVo);
		/***Then***/
		//assertEquals(1, cnt);
	}

}
