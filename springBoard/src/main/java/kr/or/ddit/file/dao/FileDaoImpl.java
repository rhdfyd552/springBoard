package kr.or.ddit.file.dao;

import java.util.List;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.file.model.FileVo;

@Repository("fileDao")
public class FileDaoImpl implements FileDaoInf{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int insertFile(FileVo fileVo) {
		return sqlSessionTemplate.insert("file.insertFile",fileVo);
	}

	@Override
	public List<FileVo> getFileList(int board_seq) {
		return sqlSessionTemplate.selectList("file.getFileList",board_seq);
	}

}
