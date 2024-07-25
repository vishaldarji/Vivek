package com.vivek.Controller;

import com.vivek.service.EmployeeService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

@RestController
public class EmployeeController {
    

    @Autowired
    private EmployeeService servicee;


   public EmployeeController(){

   }


    @GetMapping("/excel")
    public void createEmployee(HttpServletResponse response) {
        try {
            response.containsHeader("application/octet-stream");
            String headerKey = "Content-Disposition";
            String headerValue = "attachment;filename=employee.xlsx";
            response.setHeader(headerKey, headerValue);
            servicee.generateReportExcel(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
