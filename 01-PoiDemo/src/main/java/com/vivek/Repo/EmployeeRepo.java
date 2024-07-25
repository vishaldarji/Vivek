package com.vivek.Repo;
import com.vivek.enttiy.Employee;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;


public interface EmployeeRepo extends JpaRepository <Employee, Integer>{


}
