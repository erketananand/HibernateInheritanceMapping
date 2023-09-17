package com.ketan.hibernateinheritancemapping.tableperclass.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_mentors")
public class Mentor extends User{
    private double rating;
}
