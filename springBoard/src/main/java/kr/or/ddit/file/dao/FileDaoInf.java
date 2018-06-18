package kr.or.ddit.file.dao;

import java.util.List;

import kr.or.ddit.file.model.FileVo;

public interface FileDaoInf {

	public int insertFile(FileVo fileVo);
	
	public List<FileVo> getFileList(int board_seq);
}
