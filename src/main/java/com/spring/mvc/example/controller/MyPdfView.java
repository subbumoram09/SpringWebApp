package com.spring.mvc.example.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;



public class MyPdfView extends AbstractPdfView
{
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		
		Paragraph p = new Paragraph("Here you can download the dependencies for the java class com.lowagie.text.pdf.PdfWriter. Use this engine to looking through the maven repository.");
		p.setAlignment("center");
		
		Table t = new Table(1);
		t.addCell("Oracle");
		t.addCell("http://www.oracle.com");
		
		document.add(p);
		document.add(t);
	}
}
