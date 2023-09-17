package com.ketan.hibernateinheritancemapping.mappedsupperclass.services.interfaces;

import com.ketan.hibernateinheritancemapping.dtos.MentorDto;
import com.ketan.hibernateinheritancemapping.exceptions.NotFoundException;

import java.util.List;

public interface IMentorService {
    List<MentorDto> getAllMentors();
    MentorDto createMentor(MentorDto mentorDto);
    MentorDto getMentorById(Long id) throws NotFoundException;
    MentorDto updateMentorById(Long id, MentorDto mentorDto) throws NotFoundException;
    void deleteMentorById(Long id) throws NotFoundException;
}
