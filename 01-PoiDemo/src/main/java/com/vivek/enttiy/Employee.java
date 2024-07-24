package com.vivek.enttiy;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@Entity
public class Employee {

    @Id
    private Integer id;
    private String name;
    private Double sal;
}
