package com.ketan.hibernateinheritancemapping.tableperclass.controllers;

import com.ketan.hibernateinheritancemapping.dtos.MentorDto;
import com.ketan.hibernateinheritancemapping.exceptions.NotFoundException;
import com.ketan.hibernateinheritancemapping.tableperclass.services.MentorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("tpcMentorController")
@RequestMapping("/tablePerClass/mentor")
public class MentorController {

    private MentorService mentorService;

    public MentorController(MentorService mentorService) {
        this.mentorService = mentorService;
    }

    @GetMapping
    public List<MentorDto> getAllMentors() {
        return mentorService.getAllMentors();
    }

    @PostMapping
    public MentorDto createMentor(@RequestBody MentorDto mentorDto) {
        return mentorService.createMentor(mentorDto);
    }

    @GetMapping("/{id}")
    public MentorDto getMentorById(@PathVariable("id") Long id) throws NotFoundException {
        return mentorService.getMentorById(id);
    }

    @PutMapping("/{id}")
    public MentorDto updateMentorById(@PathVariable("id") Long id, @RequestBody MentorDto mentorDto) throws NotFoundException {
        return mentorService.updateMentorById(id, mentorDto);
    }

    @DeleteMapping("/{id}")
    public void deleteMentorById(@PathVariable("id") Long id) throws NotFoundException {
        mentorService.deleteMentorById(id);
    }

}
