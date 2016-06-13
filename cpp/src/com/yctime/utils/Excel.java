package com.yctime.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.struts2.ServletActionContext;

import com.yctime.pojo.Student;
public class Excel{
	

	public void writeStudent(Student aStudent, Row row) {
	    
		Cell cell = row.createCell(1);
	    cell.setCellValue(aStudent.getId());
	    cell = row.createCell(2);
	    cell.setCellValue(aStudent.getClassname());
	    cell = row.createCell(3);
	    cell.setCellValue(aStudent.getUsername());
	    cell = row.createCell(4);
	    cell.setCellValue(aStudent.getSex());
	    cell = row.createCell(5);
	    cell.setCellValue(aStudent.getTel());
	    cell = row.createCell(6);
	    cell.setCellValue(aStudent.getQq());
	    cell = row.createCell(7);
	    cell.setCellValue(aStudent.getMyflags());
	    cell = row.createCell(8);
	    cell.setCellValue(aStudent.getIntroduce());
	    cell = row.createCell(9);
	    cell.setCellValue(aStudent.getPower());
	    cell = row.createCell(10);
	    cell.setCellValue(aStudent.getIsfile());
	    cell = row.createCell(11);
	    cell.setCellValue(aStudent.getFilename());
	 
	}
	
	public void writeExcel(List<Student> listStudent, String excelFilePath) throws IOException {
	    Workbook workbook = new HSSFWorkbook();
	    Sheet sheet = workbook.createSheet();
	 
	    int rowCount = 0;
	 
	    for (Student aStudent : listStudent) {
	        Row row = sheet.createRow(++rowCount);
	        writeStudent(aStudent, row);
	    }
	 
	    try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
	        workbook.write(outputStream);
	    }
	}
	
}


