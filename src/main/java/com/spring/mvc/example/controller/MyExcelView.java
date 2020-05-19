package com.spring.mvc.example.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

public class MyExcelView extends AbstractXlsView
{
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		Sheet sheet = workbook.createSheet("Sheet1");
		
		Row r1 = sheet.createRow(0);
		Cell c1 = r1.createCell(0);
		c1.setCellValue("Company Name");
		Cell c2 = r1.createCell(0);
		c2.setCellValue("Website");
		
		Row r2 = sheet.createRow(0);
		Cell c3 = r2.createCell(0);
		c3.setCellValue("Oracle");
		Cell c4 = r2.createCell(0);
		c4.setCellValue("http://www.oracle.com");
		
	}
}
