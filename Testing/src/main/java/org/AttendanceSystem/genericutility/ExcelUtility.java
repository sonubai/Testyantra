package org.AttendanceSystem.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	private Workbook workbook;
	private Sheet sheet;
	/**
	 * this method is used to read the data from excel
	 * @param file
	 */
	public void initializeexcelfile(String file) {
		FileInputStream fisexcel;
		try {
			fisexcel = new FileInputStream(file);
			 try {
			workbook=WorkbookFactory.create(fisexcel);
			} catch (EncryptedDocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	/**
	 * this method is used to get the data from excel
	 * @param sheetName
	 * @param rownumber
	 * @param cellnumber
	 * @return
	 */
	
	public String getdatafromExcel(String sheetName ,int rownumber,int cellnumber) {
		 sheet= workbook.getSheet(sheetName);
		return new DataFormatter().formatCellValue(sheet.getRow(rownumber).getCell(cellnumber));	
	}
	/**
	 * this method is used to set the data from excel
	 * @param sheetname
	 * @param rownumber
	 * @param cellnumber
	 * @param value
	 */
	public void setdatafromExcel(String sheetname,int rownumber,int cellnumber,String value) {
		sheet=workbook.getSheet(sheetname);
		sheet.getRow(rownumber).getCell(cellnumber).setCellValue(value);	
	}
	/**
	 * this method is used to write the data to excel sheet
	 * @param file
	 */
	public void providedatetoexcel(String file) {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream( file);
			try {
				workbook.write(fos);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public String[][] getMultipleDatafromexcel(String sheetname){
		DataFormatter data=new DataFormatter();
		sheet=workbook.getSheet(sheetname);
		int rownum = sheet.getLastRowNum();
		 int cellnum = sheet.getRow(0).getLastCellNum();
		 String[][]str=new String[rownum][cellnum];
		 for(int i=1;i<=rownum;i++) {
			 for(int j=0;j<cellnum;j++) {
				 str[i-1][j]=data.formatCellValue(sheet.getRow(i).getCell(j));
			 }
		 }
		 
		 
		return str;
		
	}

}
