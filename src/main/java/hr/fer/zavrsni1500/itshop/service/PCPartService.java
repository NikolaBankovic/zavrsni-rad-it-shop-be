package hr.fer.zavrsni1500.itshop.service;

import hr.fer.zavrsni1500.itshop.dto.PCPartDto;

import java.util.List;

public interface PCPartService {
    PCPartDto getPCPartById(Long id);
    List<PCPartDto> getAllPCParts();
    PCPartDto createPCPart(PCPartDto pcPartDto);
    PCPartDto updatePCPart(Long id, PCPartDto pcPartDto);
    void deletePCPart(Long id);
}
