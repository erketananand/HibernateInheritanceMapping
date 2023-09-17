package com.ketan.hibernateinheritancemapping.tableperclass.services.interfaces;

import com.ketan.hibernateinheritancemapping.dtos.TaDto;
import com.ketan.hibernateinheritancemapping.exceptions.NotFoundException;

import java.util.List;

public interface ITaService {
    TaDto createTa(TaDto taDto);
    TaDto getTaById(Long id) throws NotFoundException;
    TaDto updateTaById(Long id, TaDto taDto) throws NotFoundException;
    void deleteTaById(Long id) throws NotFoundException;
    List<TaDto> getAllTas();
}
