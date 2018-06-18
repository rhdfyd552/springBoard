package kr.or.ddit.excel.dao;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.file.model.FileVo;

public interface ExcelDaoInf {
	public List<FileVo> getList();

	public int insertExcel(List<FileVo> list);
}
