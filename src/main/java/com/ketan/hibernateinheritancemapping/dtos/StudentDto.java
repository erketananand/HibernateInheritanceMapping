package com.ketan.hibernateinheritancemapping.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class StudentDto {
    private Long id;
    private String name;
    private String email;
    private double psp;
    private double attendance;
}
