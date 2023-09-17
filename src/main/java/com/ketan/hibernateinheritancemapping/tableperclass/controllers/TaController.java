package com.ketan.hibernateinheritancemapping.tableperclass.controllers;

import com.ketan.hibernateinheritancemapping.dtos.TaDto;
import com.ketan.hibernateinheritancemapping.exceptions.NotFoundException;
import com.ketan.hibernateinheritancemapping.tableperclass.services.TaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("tpcTaController")
@RequestMapping("/tablePerClass/ta")
public class TaController {
    private TaService taService;

    public TaController(TaService taService){
        this.taService = taService;
    }

    @GetMapping
    public List<TaDto> getAllTas(){
        return taService.getAllTas();
    }

    @GetMapping("/{id}")
    public TaDto getTaById(@PathVariable("id") Long id) throws NotFoundException {
        return taService.getTaById(id);
    }

    @PostMapping
    public TaDto createTa(@RequestBody TaDto taDto){
        return taService.createTa(taDto);
    }

    @PutMapping("/{id}")
    public TaDto updateTaById(@PathVariable("id") Long id, @RequestBody TaDto taDto) throws NotFoundException {
        return taService.updateTaById(id, taDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTaById(@PathVariable("id") Long id) throws NotFoundException {
        taService.deleteTaById(id);
    }

}
