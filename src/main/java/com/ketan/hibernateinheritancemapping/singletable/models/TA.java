package com.ketan.hibernateinheritancemapping.singletable.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_tas")
@DiscriminatorValue("3")
public class TA extends User {
    private double rating;
}
