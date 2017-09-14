package com.fireway.utils;
import java.io.IOException;  
import java.io.InputStream;  
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;  
import java.util.Map;  
  
import org.apache.commons.io.FilenameUtils;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.DateUtil;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.ss.usermodel.Sheet;  
import org.apache.poi.ss.usermodel.Workbook;  
import org.apache.poi.ss.util.CellReference;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;  
  

public class ImportFromExcelUtil {
	
	 /** 
     * Excel 2003 
     */  
    private final static String XLS = "xls";  
  
    /** 
     * Excel 2007 
     */  
    private final static String XLSX = "xlsx";  
  
    /** 
     * 由Excel文件的Sheet导出至List 
     *  
     * @param file 
     *            导入的excel文件 
     * @param sheetNum 
     *            excel工作空间,一般情况为0 
     * @return 
     */  
    public static List<Map<String, Object>> exportListFromExcel(MultipartFile file, int sheetNum,String[] columnNames,// 列名  
            String[] propertyNames) throws IOException {
    	
    		if (null == propertyNames && propertyNames.length <= 0 && null == columnNames && columnNames.length <=0){
    			return null;
    		}
    	
    	
        return exportListFromExcel(file.getInputStream(), FilenameUtils.getExtension(file.getOriginalFilename()), sheetNum,
        	columnNames,// 列名  
                propertyNames);  
    }  
  
    /** 
     * 由Excel流的Sheet导出至List 
     *  
     * @param is 
     * @param extensionName 
     * @param sheetNum 
     * @return 
     * @throws IOException 
     */  
    public static List<Map<String, Object>> exportListFromExcel(InputStream is, String extensionName, int sheetNum,
    		String[] columnNames,// 列名  
            String[] propertyNames) throws IOException {  
  
        Workbook workbook = null;  
        if (extensionName.toLowerCase().equals(XLS)) {  
            workbook = new HSSFWorkbook(is);  
        } else if (extensionName.toLowerCase().equals(XLSX)) {  
            workbook = new XSSFWorkbook(is);  
        }  
  
        return readCell(workbook, sheetNum,columnNames,propertyNames);  
    }  
  
    /** 
     * 读取Cell的值 
     *  
     * @param sheet 
     * @return 
     */  
    public static List<Map<String, Object>> readCell(Workbook workbook, int sheetNum,String[] columnNames,// 列名  
            String[] propertyNames) { 
        Sheet sheet = workbook.getSheetAt(sheetNum);  
        
        // 解析公式结果  
        // FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();  
  
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();  
        // 遍历所有行  
        // 表头即第一行  
        Row firstRow = sheet.getRow(0);
       
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {  
            Row row = sheet.getRow(i);  
            Map<String, Object> map = new HashMap<String, Object>();  
            // 遍历所有列 
            try {
				for (Cell cell : row) {  
				    // 获取单元格的类型  
				    CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
				    //获取表头每列的值
				    String cName = firstRow.getCell(cell.getColumnIndex()).getStringCellValue();
				    String key = "";
				    //列名与属性的比较  
				    for (int x=0;x<columnNames.length;x++){
				    	if (cName.equals(columnNames[x])){
				    		key = propertyNames[x];
				    	}
				    }
				    switch (cell.getCellType()) {  
				    // 字符串  
				    case Cell.CELL_TYPE_STRING:  
				        map.put(key, cell.getRichStringCellValue().getString());  
				        break;  
				    // 数字  
				    case Cell.CELL_TYPE_NUMERIC:  
				        if (DateUtil.isCellDateFormatted(cell)) { 
				        	Date d = cell.getDateCellValue();
				        	String value = com.fireway.utils.DateUtil.dateFormat(null, d);
				            map.put(key, value);  
				        } else {  
				            Double num = cell.getNumericCellValue();
				            int value = num.intValue();
				            String cellValue = String.valueOf(value);
				            map.put(key, cellValue);
				        }  
				        break;  
				    // boolean  
				    case Cell.CELL_TYPE_BOOLEAN:  
				        map.put(key, cell.getBooleanCellValue());  
				        break;  
				    // 方程式  
				    case Cell.CELL_TYPE_FORMULA:  
				        map.put(key, cell.getCellFormula());  
				        break;  
				    case Cell.CELL_TYPE_BLANK:  
				        break;  
				    case Cell.CELL_TYPE_ERROR:  
				        break;  
				    // 空值  
				    default:  
				        map.put(key, "");  
				    }  
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}  
            list.add(map);  
        }  
        return list;  
  
    }  
}
