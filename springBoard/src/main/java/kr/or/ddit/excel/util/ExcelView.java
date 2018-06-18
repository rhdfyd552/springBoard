package kr.or.ddit.excel.util;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVo;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelView extends AbstractExcelPoiView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		List<BoardVo> list = (List<BoardVo>) model.get("excelList");
		 
        //Sheet 생성
        Sheet sheet = workbook.createSheet("테스트");
        Row row = null;
        int rowCount = 0;
        int cellCount = 0;

        // 제목 Cell 생성
        row = sheet.createRow(rowCount++);

        row.createCell(cellCount++).setCellValue("게시글 번호");
        row.createCell(cellCount++).setCellValue("부모글 번호");
        row.createCell(cellCount++).setCellValue("게시판 번호");
        row.createCell(cellCount++).setCellValue("그룹 번호");
        row.createCell(cellCount++).setCellValue("제목");
        row.createCell(cellCount++).setCellValue("내용");
        row.createCell(cellCount++).setCellValue("작성자");
        row.createCell(cellCount++).setCellValue("작성일");
        row.createCell(cellCount++).setCellValue("삭제상태");
       
        // 데이터 Cell 생성
        for (BoardVo board : list) {
            row = sheet.createRow(rowCount++);
            cellCount = 0;
            row.createCell(cellCount++).setCellValue(board.getBoard_seq());
            row.createCell(cellCount++).setCellValue(board.getPboard_seq());
            row.createCell(cellCount++).setCellValue(board.getCategory_seq());
            row.createCell(cellCount++).setCellValue(board.getGroup_seq());
            row.createCell(cellCount++).setCellValue(board.getTitle());
            row.createCell(cellCount++).setCellValue(board.getContent());
            row.createCell(cellCount++).setCellValue(board.getReg_id());
            row.createCell(cellCount++).setCellValue(board.getReg_dt());
            row.createCell(cellCount++).setCellValue(board.getDel_yn());
        }

    }

}
