package com.vivek.com.vivek;


import com.vivek.Repo.EmployeeRepo;
import com.vivek.enttiy.Employee;
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

    List<Employee> emps=repo.findAll();

    public void  generateReportExcel(HttpServletResponse responce ){
        HSSFSheet sheet;
        try (HSSFWorkbook sheets = new HSSFWorkbook()) {
            sheet = sheets.createSheet("Employee_Sheet");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("id");
        row.createCell(1).setCellValue("Name");
        row.createCell(2).setCellValue("Sal");

        int specificRow=1;
        for(Employee emp:emps){
            HSSFRow dataRow = sheet.createRow(specificRow);
            dataRow.createCell(0).setCellValue(emp.get);


        }




    }


}
