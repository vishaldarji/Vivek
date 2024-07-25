package com.vivek.enttiy;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
public class Employee {

   @Id
    private Integer id;
    private String name;
    private Double sal;
}
