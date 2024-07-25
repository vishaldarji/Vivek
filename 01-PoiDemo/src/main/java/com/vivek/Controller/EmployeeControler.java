package com.vivek.Controller;

import com.vivek.com.vivek.EmployeeService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class  EmployeeControler {

    private EmployeeService service;

    @GetMapping("/excel")
    public void createEmployee(HttpServletResponse response) {
        try {
            response.containsHeader("application/octet-stream");
            String headerKey="Content-Disposition";
            String headerValue="attachment;filename=employee.xlsx";
            response.setHeader(headerKey,headerValue);
            service.generateReportExcel(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
