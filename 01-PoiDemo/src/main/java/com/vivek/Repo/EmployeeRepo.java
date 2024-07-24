package com.vivek.Repo;

import com.vivek.enttiy.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository <Employee, Integer>{


}
