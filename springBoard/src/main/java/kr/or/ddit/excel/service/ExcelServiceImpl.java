package kr.or.ddit.excel.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.excel.dao.ExcelDaoInf;
import kr.or.ddit.file.model.FileVo;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service("eService")
public class ExcelServiceImpl implements ExcelServiceInf{
	@Resource(name="eDao")
	private ExcelDaoInf eDao;
	
	

	@Override
	public List<FileVo> getList() {
		return eDao.getList();
	}

	@Override
	public String xlsxExcel(MultipartHttpServletRequest request) {
		int cnt=0;
		
		List<FileVo> list = new ArrayList<>();

		MultipartFile file = request.getFile("file");
		XSSFWorkbook workbook = null;
		FileVo vo = null;
		
		try {
			workbook = new XSSFWorkbook(file.getInputStream());
			
			XSSFSheet sheet;
			XSSFRow row;
			XSSFCell cell;
			 // Sheet 탐색 for문
            for(int sheetIndex = 0 ; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
                // 현재 Sheet 반환
                sheet = workbook.getSheetAt(sheetIndex);
                // row 탐색 for문
                for(int rowIndex=0; rowIndex < sheet.getPhysicalNumberOfRows(); rowIndex++) {
                    // row 0은 헤더정보이기 때문에 무시
                    if(rowIndex != 0) {
                        // 현재 row 반환
                        row = sheet.getRow(rowIndex);
                        vo = new FileVo();
                        String value;
                        
                        // row의 첫번째 cell값이 비어있지 않은 경우 만 cell탐색
                        if(!"".equals(row.getCell(0).getStringCellValue())) {
                            
                            // cell 탐색 for 문
                            for(int cellIndex=0;cellIndex<row.getPhysicalNumberOfCells(); cellIndex++) {
                                cell = row.getCell(cellIndex);
                                
                                if(true) {
                                    value = "";
                                    // cell 스타일이 다르더라도 String으로 반환 받음
                                    switch (cell.getCellTypeEnum()){
                                    case FORMULA:
                                        value = cell.getCellFormula()+"";
                                        break;
                                    case NUMERIC:
                                        value = cell.getNumericCellValue()+"";
                                        break;
                                    case STRING:
                                        value = cell.getStringCellValue()+"";
                                        break;
                                    case BOOLEAN:
                                        value = cell.getBooleanCellValue()+"";
                                        break;
                                    case ERROR:
                                        value = cell.getErrorCellValue()+"";
                                        break;
                                    default:
                                        value = new String();
                                        break;
                                    }
                                    
                                    // 현재 column index에 따라서 vo에 입력
                                    switch (cellIndex) {
                                    case 0: // 아이디
                                        break;
                                        
                                    case 1: // 이름
                                    	vo.setFi_board_seq(Integer.parseInt(value));;
                                        break;
                                        
                                    case 2: // 나이
                                    	vo.setFi_path(value);
                                        break;
                                        
                                    case 3: // 이메일
                                    	vo.setFi_name(value);
                                        break;
                                    default:
                                        break;
                                    }
                                }
                            }
                           list.add(vo);
                        }
                    }
                }
            }
        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        } 
		cnt = eDao.insertExcel(list);
		if(cnt>=1){
			return "입력 성공";
		}else{
			return "입력실패";
		}
	}
		
}
