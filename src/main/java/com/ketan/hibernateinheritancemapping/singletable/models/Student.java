package com.ketan.hibernateinheritancemapping.singletable.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_students")
@DiscriminatorValue("1")
public class Student extends User {
    private double psp;
    private double attendance;
}
