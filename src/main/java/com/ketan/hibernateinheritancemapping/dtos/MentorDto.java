package com.ketan.hibernateinheritancemapping.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MentorDto {
    private Long id;
    private String name;
    private String email;
    private double averageRating;
}
