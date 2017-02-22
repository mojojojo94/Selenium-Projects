package ReadExcelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel2{
    
    public Object[][] getExcelData(String fileName,String sheetName) throws IOException {
    Object [][] arrayExcelData = null;
    File src=new File(fileName);
    FileInputStream fis=new FileInputStream(src);
    XSSFWorkbook wb=new XSSFWorkbook(fis);
    XSSFSheet sh=wb.getSheet(sheetName);
    int totalCols=sh.getRow(0).getLastCellNum();
    int totalRows=sh.getLastRowNum();
    arrayExcelData = new String[totalRows-1][totalCols];
    for(int i=1;i<totalRows;i++){
        for(int j=0;j<totalCols; j++){
            arrayExcelData[i-1][j]=sh.getRow(i).getCell(j).getStringCellValue();
        }
    }
    return arrayExcelData;
    }

	/*public Object[][] getExcelData(String fileName, String sheetName) {
		// TODO Auto-generated method stub
		return null;
	}*/
}