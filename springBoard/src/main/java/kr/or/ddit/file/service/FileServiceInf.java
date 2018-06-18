package kr.or.ddit.file.service;

import java.util.List;

import kr.or.ddit.file.model.FileVo;

public interface FileServiceInf {
	public List<FileVo> getFileList(int board_seq);
}
