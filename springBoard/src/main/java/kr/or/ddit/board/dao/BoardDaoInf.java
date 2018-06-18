package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVo;

public interface BoardDaoInf {
	public List<BoardVo> allBoardList(Map<String, Integer> map);
	
	public int countBoard();
	
	public int noticeCountBoard(int no_seq);
	
	public List<BoardVo> selectBoard(Map<String, Integer> map);
	
	public BoardVo getBoard(int board_seq);
	
	public int insertBoard(BoardVo boardVo);

	public int insertReplyBoard(BoardVo boardVo);

	public void deleteBoard(int board_seq);

	public void boardModify(BoardVo boardVo);
}
