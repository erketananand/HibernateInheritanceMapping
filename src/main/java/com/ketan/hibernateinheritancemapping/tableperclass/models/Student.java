package com.ketan.hibernateinheritancemapping.tableperclass.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_students")
public class Student extends User{
    private double psp;
    private double attendance;
}
