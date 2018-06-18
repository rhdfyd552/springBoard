package kr.or.ddit.board.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.file.dao.FileDaoInf;
import kr.or.ddit.file.model.FileVo;

@Service("boardService")
public class BoardServiceImpl implements BoardServiceInf{
	Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Resource(name="boardDao")
	private BoardDaoInf boardDao;
	
	@Resource(name="fileDao")
	private FileDaoInf fileDao;
	
	@Override
	public Map<String, Object> allBoardList(Map<String, Integer> map) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<BoardVo>boardList = boardDao.allBoardList(map);
		String pageNav = BoardVo.makePageNav(map.get("page"), boardDao.countBoard());
		
		resultMap.put("boardList", boardList);
		resultMap.put("pageNav", pageNav);
		
		return resultMap;
	}

	

	@Override
	public Map<String, Object> selectBoard(Map<String, Integer> map) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<BoardVo>boardList = boardDao.selectBoard(map);
		String pageNav = BoardVo.makeSelPageNav(map.get("category_seq"),map.get("page"), boardDao.noticeCountBoard(map.get("category_seq")));
		
		resultMap.put("boardList", boardList);
		resultMap.put("selPageNav", pageNav);
		
		return resultMap;
	}



	@Override
	public BoardVo getBoard(int board_seq) {
		return boardDao.getBoard(board_seq);
	}



	@Override
	public int insertBoard(BoardVo boardVo, FileVo fileVo){
		int boardCnt = boardDao.insertBoard(boardVo);
		
		if(fileVo.getFi_name()!=null || fileVo.getFi_name().equals("") != true){
			logger.debug("{}","****************"+boardVo.getBoard_seq());
			fileVo.setFi_board_seq(boardVo.getBoard_seq());
			fileDao.insertFile(fileVo);
		}

		return boardCnt;
	}



	@Override
	public int insertReplyBoard(BoardVo boardVo, FileVo file) {
		int boardCnt = boardDao.insertReplyBoard(boardVo);
		
		if(file.getFi_name()!=null || file.getFi_name().equals("")!=true){
			file.setFi_board_seq(boardVo.getBoard_seq());
			fileDao.insertFile(file);
		}

		return boardCnt;
	}



	@Override
	public void deleteBoard(int board_seq) {
		boardDao.deleteBoard(board_seq);
	}



	@Override
	public void boardModify(BoardVo boardVo, FileVo file) {
		boardDao.boardModify(boardVo);
		
		if(file.getFi_name()!=null || file.getFi_name().equals("") != true){
			file.setFi_board_seq(boardVo.getBoard_seq());
			fileDao.insertFile(file);
		}
		
	}
	
	
}
