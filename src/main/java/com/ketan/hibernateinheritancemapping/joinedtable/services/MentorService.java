package com.ketan.hibernateinheritancemapping.joinedtable.services;

import com.ketan.hibernateinheritancemapping.dtos.MentorDto;
import com.ketan.hibernateinheritancemapping.exceptions.NotFoundException;
import com.ketan.hibernateinheritancemapping.joinedtable.models.Mentor;
import com.ketan.hibernateinheritancemapping.joinedtable.repositories.MentorRepository;
import com.ketan.hibernateinheritancemapping.joinedtable.services.interfaces.IMentorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("jtMentorService")
public class MentorService implements IMentorService {
    private MentorRepository mentorRepository;

    public MentorService(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    private MentorDto convertMentorToMentorDto(Mentor mentor){
        return MentorDto.builder()
                .id(mentor.getId())
                .name(mentor.getName())
                .email(mentor.getEmail())
                .averageRating(mentor.getRating())
                .build();
    }

    private Mentor convertMentorDtoToMentor(MentorDto mentorDto, Mentor mentor){
        mentor.setName(mentorDto.getName());
        mentor.setEmail(mentorDto.getEmail());
        mentor.setRating(mentorDto.getAverageRating());
        return mentor;
    }

    @Override
    public List<MentorDto> getAllMentors() {
        List<Mentor> mentors = mentorRepository.findAll();
        List<MentorDto> mentorDtos = new ArrayList<>();
        for (Mentor mentor : mentors) {
            mentorDtos.add(convertMentorToMentorDto(mentor));
        }
        return mentorDtos;
    }

    @Override
    public MentorDto createMentor(MentorDto mentorDto) {
        Mentor mentor = convertMentorDtoToMentor(mentorDto, new Mentor());
        Mentor savedMentor = mentorRepository.save(mentor);
        return convertMentorToMentorDto(savedMentor);
    }

    @Override
    public MentorDto getMentorById(Long id) throws NotFoundException {
        Optional<Mentor> optionalMentor = mentorRepository.findById(id);
        if (optionalMentor.isPresent()) {
            Mentor mentor = optionalMentor.get();
            return convertMentorToMentorDto(mentor);
        } else throw new NotFoundException("Mentor with id " + id + " not found");
    }

    @Override
    public MentorDto updateMentorById(Long id, MentorDto mentorDto) throws NotFoundException {
        Optional<Mentor> optionalMentor = mentorRepository.findById(id);
        if (optionalMentor.isPresent()) {
            Mentor mentor = convertMentorDtoToMentor(mentorDto, optionalMentor.get());
            Mentor savedMentor = mentorRepository.save(mentor);
            return convertMentorToMentorDto(savedMentor);
        } else throw new NotFoundException("Mentor with id " + id + " not found");
    }

    @Override
    public void deleteMentorById(Long id) throws NotFoundException {
        if(mentorRepository.existsById(id))
            mentorRepository.deleteById(id);
        else throw new NotFoundException("Mentor with id " + id + " not found");
    }
}
