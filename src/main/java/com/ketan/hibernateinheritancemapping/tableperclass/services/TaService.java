package com.ketan.hibernateinheritancemapping.tableperclass.services;

import com.ketan.hibernateinheritancemapping.dtos.TaDto;
import com.ketan.hibernateinheritancemapping.exceptions.NotFoundException;
import com.ketan.hibernateinheritancemapping.tableperclass.models.TA;
import com.ketan.hibernateinheritancemapping.tableperclass.repositories.TaRepository;
import com.ketan.hibernateinheritancemapping.tableperclass.services.interfaces.ITaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("tpcTaService")
public class TaService implements ITaService {
    private TaRepository taRepository;
    TaService(TaRepository taRepository){
        this.taRepository = taRepository;
    }

    private TaDto convertTaToTaDto(TA ta){
        return TaDto.builder()
                .id(ta.getId())
                .name(ta.getName())
                .email(ta.getEmail())
                .averageRating(ta.getRating())
                .build();
    }

    private TA convertTaDtoToTa(TaDto taDto, TA ta){
        ta.setName(taDto.getName());
        ta.setEmail(taDto.getEmail());
        ta.setRating(taDto.getAverageRating());
        return ta;
    }

    @Override
    public TaDto createTa(TaDto taDto) {
        TA ta = convertTaDtoToTa(taDto, new TA());
        TA savedTa = taRepository.save(ta);
        return convertTaToTaDto(savedTa);
    }

    @Override
    public TaDto getTaById(Long id) throws NotFoundException {
        Optional<TA> optionalTa = taRepository.findById(id);
        if(optionalTa.isPresent()){
            TA ta = optionalTa.get();
            return convertTaToTaDto(ta);
        } else throw new NotFoundException("Ta with id " + id + " not found");
    }

    @Override
    public TaDto updateTaById(Long id, TaDto taDto) throws NotFoundException {
        Optional<TA> optionalTa = taRepository.findById(id);
        if(optionalTa.isPresent()){
            TA ta = convertTaDtoToTa(taDto, optionalTa.get());
            TA savedTa = taRepository.save(ta);
            return convertTaToTaDto(savedTa);
        } else throw new NotFoundException("Ta with id " + id + " not found");
    }

    @Override
    public void deleteTaById(Long id) throws NotFoundException {
        if(taRepository.existsById(id)){
            taRepository.deleteById(id);
        } else throw new NotFoundException("Ta with id " + id + " not found");
    }

    @Override
    public List<TaDto> getAllTas() {
        List<TA> tas = taRepository.findAll();
        List<TaDto> taDtos = new ArrayList<>();
        for(TA ta : tas){
            taDtos.add(convertTaToTaDto(ta));
        }
        return taDtos;
    }
}
