package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.board.model.BoardVo;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDaoInf{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<BoardVo> allBoardList(Map<String, Integer> map) {
		return sqlSessionTemplate.selectList("board.allBoardList",map);
	}

	@Override
	public int countBoard() {
		return sqlSessionTemplate.selectOne("board.countBoard");
	}

	@Override
	public List<BoardVo> selectBoard(Map<String, Integer> map) {
		return sqlSessionTemplate.selectList("board.selectBoard",map);
	}

	@Override
	public BoardVo getBoard(int board_seq) {
		return sqlSessionTemplate.selectOne("board.getBoard",board_seq);
	}

	@Override
	public int insertBoard(BoardVo boardVo) {
		return sqlSessionTemplate.insert("board.insertBoard", boardVo);
	}

	@Override
	public int noticeCountBoard(int no_seq) {
		return sqlSessionTemplate.selectOne("board.noticeCountBoard",no_seq);
	}

	@Override
	public int insertReplyBoard(BoardVo boardVo) {
		return sqlSessionTemplate.insert("board.replyBoard",boardVo);
	}

	@Override
	public void deleteBoard(int board_seq) {
		sqlSessionTemplate.update("board.deleteBoard",board_seq);
	}

	@Override
	public void boardModify(BoardVo boardVo) {
		sqlSessionTemplate.update("board.boardModify",boardVo);
	}
	
	
}
