package com.vivek.service;


import com.vivek.Repo.EmployeeRepo;
import com.vivek.enttiy.Employee;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;


@Service
public class EmployeeService {

    @Autowired
     private EmployeeRepo repo;


    public void  generateReportExcel(HttpServletResponse responce ) throws IOException {

        HSSFWorkbook sheets = new HSSFWorkbook();
        HSSFSheet sheet = sheets.createSheet("Employee_Sheet");
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("id");
        row.createCell(1).setCellValue("Name");
        row.createCell(2).setCellValue("Sal");
        List<Employee> emps=repo.findAll();
        int specificRow=1;
        for(Employee emp:emps){
            HSSFRow dataRow = sheet.createRow(specificRow);
            dataRow.createCell(0).setCellValue(emp.getId());
            dataRow.createCell(1).setCellValue(emp.getName());
            dataRow.createCell(2).setCellValue(emp.getSal());
            specificRow++;
        }

        ServletOutputStream stream = responce.getOutputStream();
         sheets.write(stream);
         sheets.close();
         stream.close();



    }


}
