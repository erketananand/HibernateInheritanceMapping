package com.ketan.hibernateinheritancemapping.singletable.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_mentors")
@DiscriminatorValue("2")
public class Mentor extends User {
    private double rating;
}
