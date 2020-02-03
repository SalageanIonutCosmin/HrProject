package com.sda.HRProject.util;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sda.HRProject.model.Company;
import com.sda.HRProject.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class GenerateEmployeePDF {

    private static final Logger logger = LoggerFactory.getLogger(GenerateEmployeePDF.class);

    public static ByteArrayInputStream employeesReport(Employee employee) {
        Company company = employee.getCurrentCompany();

        Document document = new Document();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        String str = "\n";
        String str1 = String.format("ACT ADITIONAL nr. %s/%s\nla Contractul individual de munca nr. %s/%s\ndin Registrul de evidenta al Salariatilor",
                employee.getAdditionalActNumber(), date.format(formatter), employee.getContractNumber(), employee.getHireDate());
        String str2 = "Partile contractate";
        String str3 = String.format("%s, cu sediul in %s, inregistrata la Registrul Comertului sub nr. %s, cod unic %s, reprezentata legal prin %s, incalitate de Director General,\n\nsi:\n\nSalariatul - dl./dna. %s, cu CNP:%s, convin modificarea urmatoarelor elemente ale contractului individual de munca incepand cu data de %s",
                company, company.getAddress(), company.getRegistrationNumber(), company.getCAENCode(), company.getAdministratorName(),
                employee.getFirstName() + " " + employee.getLastName(), employee.getCNP(), date.format(formatter));
        String str4 = "1.Salariul de incadrade de la ... lei la ... lei.";
        String str5 = "Prezentul act aditional face parte integrata din contractul individual de munca.\nS-a incheiat in doua exemplare, cate unul pentru fiecare parte.";
        String str6 = String.format("Angajator,\n%s\nReprezentatn legal\n%s", employee.getCurrentCompany(), company.getAdministratorName());
        String str7 = String.format("Salariat,\nNume: %s\n\nSemnatura:....................", employee.getFirstName() + " " + employee.getLastName());

        Font boldFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        Font font = FontFactory.getFont(FontFactory.HELVETICA);

        Paragraph paragraph = new Paragraph(str);
        Paragraph paragraph1 = new Paragraph(str1);
        Paragraph paragraph2 = new Paragraph(str2);
        Paragraph paragraph3 = new Paragraph(str3);
        Paragraph paragraph4 = new Paragraph(str4);
        Paragraph paragraph5 = new Paragraph(str5);
        Paragraph paragraph6 = new Paragraph(str6);
        Paragraph paragraph7 = new Paragraph(str7);
        paragraph1.setAlignment(Element.ALIGN_CENTER);
        paragraph1.setFont(boldFont);
        paragraph2.setAlignment(Element.ALIGN_LEFT);
        paragraph2.setFont(boldFont);
        paragraph3.setAlignment(Element.ALIGN_LEFT);
        paragraph3.setFont(boldFont);
        paragraph4.setAlignment(Element.ALIGN_LEFT);
        paragraph4.setFont(boldFont);
        paragraph5.setAlignment(Element.ALIGN_LEFT);
        paragraph5.setFont(font);
        paragraph6.setAlignment(Element.ALIGN_CENTER);
        paragraph6.setFont(font);
        paragraph7.setAlignment(Element.ALIGN_CENTER);
        paragraph7.setFont(font);
        try {
            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);
            //Path path = Paths.get(ClassLoader.getSystemResource("performia-logo.png").toURI());
            PdfWriter.getInstance(document, outputStream);
            document.open();
            document.setMargins(30, 4, 4, 4);
            Image image = Image.getInstance("E:\\Projects\\HRProject\\src\\main\\resources\\static\\pdf\\performia-logo.png");
            image.scaleAbsolute(200, 100);
            document.add(image);
            document.add(paragraph1);
            document.add(paragraph);
            document.add(paragraph);
            document.add(paragraph2);
            document.add(paragraph);
            document.add(paragraph);
            document.add(paragraph3);
            document.add(paragraph4);
            document.add(paragraph);
            document.add(paragraph);
            document.add(paragraph5);
            document.add(paragraph);
            document.add(paragraph);
            table.addCell(getCell(paragraph6, PdfPCell.ALIGN_CENTER));
            table.addCell(getCell(paragraph7, PdfPCell.ALIGN_CENTER));
            document.add(table);
            document.close();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(outputStream.toByteArray());
    }

    public static PdfPCell getCell(Paragraph paragraph, int alignment) {
        PdfPCell cell = new PdfPCell(new Paragraph(paragraph));
        cell.setPadding(0);
        cell.setHorizontalAlignment(alignment);
        cell.setBorder(PdfPCell.NO_BORDER);
        return cell;
    }
}
