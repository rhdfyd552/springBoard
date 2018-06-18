package kr.or.ddit.excel.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.file.model.FileVo;

public interface ExcelServiceInf {
	public List<FileVo> getList();
	
	public String xlsxExcel(MultipartHttpServletRequest request);
}
