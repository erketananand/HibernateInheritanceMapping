package com.ketan.hibernateinheritancemapping.joinedtable.models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_tas")
@PrimaryKeyJoinColumn(name = "user_id")
public class TA extends User {
    private double rating;
}
