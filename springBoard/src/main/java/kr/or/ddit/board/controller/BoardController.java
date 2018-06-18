package kr.or.ddit.board.controller;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.file.model.FileVo;
import kr.or.ddit.file.service.FileServiceInf;
import kr.or.ddit.notice.service.NoticeServiceInf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;



@RequestMapping("/board")
@Controller
public class BoardController {
	Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Resource(name="boardService")
	private BoardServiceInf boardService;
	
	@Resource(name="noticeService")
	private NoticeServiceInf noticeService;
	
	@Resource(name="fileService")
	private FileServiceInf fileService;
	
	
	
	@RequestMapping(value="/boardList",method=RequestMethod.GET ,params={"no_seq","page","pageSize"})
	public String selectBoard(HttpServletRequest request){
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("category_seq", Integer.parseInt(request.getParameter("no_seq")));
		map.put("page", Integer.parseInt(request.getParameter("page")));
		map.put("pageSize", 10);
		
		
		Map<String, Object>page = boardService.selectBoard(map);
		List<BoardVo>boardList = (List<BoardVo>)page.get("boardList");
		for(BoardVo boardVo : boardList){
			boardVo.setTitle(boardVo.getTitle().replace(" ", "&nbsp"));
		}
		
		request.setAttribute("selPageNav", page.get("selPageNav"));
		request.setAttribute("boardList", boardList);
		return "board/main/getBoardList";
	}
	
	@RequestMapping(value="/getBoard", method=RequestMethod.GET)
	public String getBoard(Model model,@RequestParam("board_seq")int board_seq){
		BoardVo boardVO = boardService.getBoard(board_seq);
		List<FileVo> fileList = fileService.getFileList(board_seq);
		model.addAttribute("boardVO", boardVO);
		model.addAttribute("fileList", fileList);
		//model.addAttribute("board_seq", board_seq);
		
		return "board/board";
	}
	
	@RequestMapping("/formBoard")
	public String boardForm(){
		
		return "board/boardForm";
	}
	
	
	@RequestMapping(value="/insertBoard",params={"title","content","category_seq","reg_id"})
	public String insertBoard(BoardVo boardVo,MultipartHttpServletRequest multipartReques,
			 HttpServletRequest request){
		
		MultipartFile multipartFile =  multipartReques.getFile("file");
		
		String uploadUrl = "/upload";
		String path = request.getServletContext().getRealPath(uploadUrl);
		String name = multipartFile.getName();
		String originalFileName = multipartFile.getOriginalFilename();
		String filePath = path + File.separator + UUID.randomUUID().toString();
		
		FileVo file = new FileVo();
		
		file.setFi_path(filePath);
		file.setFi_name(originalFileName);
		
		boardService.insertBoard(boardVo, file);
		
		try {
			multipartFile.transferTo(new File(filePath));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/board/getBoard?board_seq="+boardVo.getBoard_seq();
	}
	
	@RequestMapping(value="/insertReplyBoard")
	public String insertReplyBoard(BoardVo boardVo,MultipartHttpServletRequest multipartReques,
			HttpServletRequest request){
		MultipartFile multipartFile =  multipartReques.getFile("file");
		
		String uploadUrl = "/upload";
		String path = request.getServletContext().getRealPath(uploadUrl);
		String name = multipartFile.getName();
		String originalFileName = multipartFile.getOriginalFilename();
		String filePath = path + File.separator + UUID.randomUUID().toString();
		
		FileVo file = new FileVo();
		
		file.setFi_path(filePath);
		file.setFi_name(originalFileName);
		
		boardService.insertReplyBoard(boardVo, file);
		
		try {
			multipartFile.transferTo(new File(filePath));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/board/getBoard?board_seq="+boardVo.getBoard_seq();
	}
	
	@RequestMapping(value="/updateBoard")
	public String updateBoard(BoardVo boardVo,MultipartHttpServletRequest multipartReques,
			HttpServletRequest request){
		MultipartFile multipartFile =  multipartReques.getFile("file");
		
		String uploadUrl = "/upload";
		String path = request.getServletContext().getRealPath(uploadUrl);
		String name = multipartFile.getName();
		String originalFileName = multipartFile.getOriginalFilename();
		String filePath = path + File.separator + UUID.randomUUID().toString();
		
		FileVo file = new FileVo();
		
		file.setFi_path(filePath);
		file.setFi_name(originalFileName);
		
		boardService.boardModify(boardVo, file);
		
		try {
			multipartFile.transferTo(new File(filePath));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/board/getBoard?board_seq="+boardVo.getBoard_seq();
	}
	
	@RequestMapping("/replyBoard")
	public String replyBoard(int board_seq,Model model){
		BoardVo boardVo = boardService.getBoard(board_seq);
		String noticeName = noticeService.noticeName(boardVo.getCategory_seq());
		model.addAttribute("boardVo", boardVo);
		model.addAttribute("category_seq", boardVo.getCategory_seq());
		model.addAttribute("noticeName", noticeName);
		return "board/replyBoardForm";
	}
	
	@RequestMapping("/deleteBoard")
	public String deleteBoard(int board_seq){
		boardService.deleteBoard(board_seq);
		return "redirect:/boardList?page=1&pageSize=10";
	}
	
	@RequestMapping("/boardModify")
	public String boardModify(int board_seq,Model model){
		BoardVo boardVO = boardService.getBoard(board_seq);
		model.addAttribute("boardVO", boardVO);
		
		return "board/boardModify";
	}
}
