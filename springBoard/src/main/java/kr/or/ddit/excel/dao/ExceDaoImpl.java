package kr.or.ddit.excel.dao;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.file.model.FileVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("eDao")
public class ExceDaoImpl implements ExcelDaoInf{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<FileVo> getList() {
		return sqlSessionTemplate.selectList("file.list");
	}

	@Override
	public int insertExcel(List<FileVo> vo) {
		return sqlSessionTemplate.insert("file.insertFile",vo);
	}
	
	
}
