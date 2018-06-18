package kr.or.ddit.excel.util;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.servlet.view.AbstractView;



public abstract class AbstractExcelPoiView extends AbstractView{
	private static final String CONTENT_TYPE_XLSX = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	 
	 
	@Override
	protected boolean generatesDownloadContent() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Workbook workbook = new XSSFWorkbook();
		
		setContentType(CONTENT_TYPE_XLSX);
		
		buildExcelDocument(model, workbook, request, response);
		
		 response.setContentType(getContentType());
		 
	        // Flush byte array to servlet output stream.
	        ServletOutputStream out = response.getOutputStream();
	        out.flush();
	        workbook.write(out);
	        out.flush();
	        if (workbook instanceof SXSSFWorkbook) {
	            ((SXSSFWorkbook) workbook).dispose();
	        }
		
	}

	 protected abstract void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	
}