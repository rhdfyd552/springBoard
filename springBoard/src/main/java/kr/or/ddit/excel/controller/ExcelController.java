package kr.or.ddit.excel.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.excel.service.ExcelServiceInf;
import kr.or.ddit.file.model.FileVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RequestMapping("/excel")
@Controller
public class ExcelController {
	@Resource(name="eService")
	private ExcelServiceInf eService;
	
	@RequestMapping("/main")
	public String main(){
		return "excel/main";
	}
	
	@RequestMapping("/test")
	public String excel(Map<String, Object> ModelMap, HttpServletResponse response){
		
		response.setHeader("Content-disposition", "attachment; filename=test.xlsx");
		List<FileVo> excelList = eService.getList();
		
		ModelMap.put("excelList", excelList);
		
		return "excelView";
	}
	
	@RequestMapping("/insert")
	public String insert(MultipartHttpServletRequest request,Model model){
		
		String str = eService.xlsxExcel(request);
		
		model.addAttribute("str", str);
		return "excel/result";
	}
}
