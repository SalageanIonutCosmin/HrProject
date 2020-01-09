package com.sda.HRProject.util;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sda.HRProject.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class GenerateEmployeePDF {

    private static final Logger logger = LoggerFactory.getLogger(GenerateEmployeePDF.class);

    public static ByteArrayInputStream employeesReport(Employee employee) {
        Document document = new Document();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        try {
//            PdfPTable table = new PdfPTable(12);
//            table.setWidthPercentage(100);
//
//            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//
//            PdfPCell hcell;
//            hcell = new PdfPCell(new Phrase("idEmployee", headFont));
//            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(hcell);
//
//            hcell = new PdfPCell(new Phrase("First Name", headFont));
//            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(hcell);
//
//            hcell = new PdfPCell(new Phrase("Last Name", headFont));
//            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(hcell);
//
//            hcell = new PdfPCell(new Phrase("Address", headFont));
//            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(hcell);
//
//            hcell = new PdfPCell(new Phrase("CNP", headFont));
//            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(hcell);
//
//            hcell = new PdfPCell(new Phrase("Studies", headFont));
//            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(hcell);
//
//            hcell = new PdfPCell(new Phrase("Position", headFont));
//            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(hcell);
//
//            hcell = new PdfPCell(new Phrase("Days Off", headFont));
//            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(hcell);
//
//            hcell = new PdfPCell(new Phrase("Norm", headFont));
//            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(hcell);
//
//            hcell = new PdfPCell(new Phrase("Hire Date", headFont));
//            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(hcell);
//
//            hcell = new PdfPCell(new Phrase("End Date", headFont));
//            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(hcell);
//
//            hcell = new PdfPCell(new Phrase("Salary", headFont));
//            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(hcell);
//
//            PdfPCell cell;
//
//            cell = new PdfPCell(new Phrase(employee.getIdEmployee().toString()));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(employee.getFirstName()));
//            cell.setPadding(0);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(employee.getLastName()));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(employee.getAddress()));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(employee.getCNP()));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(String.valueOf(employee.getStudies())));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(employee.getPosition()));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(employee.getDaysOff().toString()));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(employee.getNorm()));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(employee.getHireDate()));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(employee.getEndDate()));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase((employee.getSalaryList().toString())));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(cell);
//
//            PdfWriter.getInstance(document, outputStream);
//            document.open();
//            document.add(table);
//            document.close();
//        } catch (DocumentException e) {
//            logger.error("Error occurred:{0}", e);
//        }
//        return new ByteArrayInputStream(outputStream.toByteArray());
//    }
        String str1 = "Electrogrup, cu sediul in Cluj...." + employee.getIdEmployee().toString();
        String str2 = "Electrogrup, cu sediul in Cluj...." + employee.getLastName();

        Paragraph paragraph1 = new Paragraph(str1);
        Paragraph paragraph2 = new Paragraph(str2);
        try {
            PdfWriter.getInstance(document, outputStream);
            document.open();
            document.add(paragraph1);
            document.add(paragraph2);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(outputStream.toByteArray());
    }
}
