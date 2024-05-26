package hr.fer.zavrsni1500.itshop.service;

import hr.fer.zavrsni1500.itshop.dto.PCDto;

import java.util.List;

public interface PCService {

    PCDto getPCById(Long id);
    List<PCDto> getAllPCs();
    PCDto createPC(PCDto pcDto);
    PCDto updatePC(Long id, PCDto pcDto);
    void deletePC(Long id);
}
