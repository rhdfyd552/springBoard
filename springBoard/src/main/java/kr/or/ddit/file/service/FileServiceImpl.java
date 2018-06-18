package kr.or.ddit.file.service;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.file.dao.FileDaoInf;
import kr.or.ddit.file.model.FileVo;

import org.springframework.stereotype.Service;

@Service("fileService")
public class FileServiceImpl implements FileServiceInf{
	@Resource(name="fileDao")
	private FileDaoInf fileDao;
	
	@Override
	public List<FileVo> getFileList(int board_seq) {
		
		return fileDao.getFileList(board_seq);
	}

}
