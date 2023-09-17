package com.ketan.hibernateinheritancemapping.mappedsupperclass.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "msc_students")
public class Student extends User{
    private double psp;
    private double attendance;
}
