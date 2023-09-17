package com.ketan.hibernateinheritancemapping.tableperclass.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_tas")
public class TA extends User{
    private double rating;
}
