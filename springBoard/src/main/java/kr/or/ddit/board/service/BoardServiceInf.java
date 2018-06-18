package kr.or.ddit.board.service;

import java.util.Map;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.file.model.FileVo;

public interface BoardServiceInf {
	
	public Map<String, Object> allBoardList(Map<String, Integer> map);
		
	public Map<String, Object> selectBoard(Map<String, Integer> map);
	
	public BoardVo getBoard(int board_seq);
	
	public int insertBoard(BoardVo boardVo,FileVo fileVo);

	public int insertReplyBoard(BoardVo boardVo, FileVo file);

	public void deleteBoard(int board_seq);

	public void boardModify(BoardVo boardVo, FileVo file);

}
