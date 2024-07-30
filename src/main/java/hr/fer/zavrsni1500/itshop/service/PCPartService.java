package hr.fer.zavrsni1500.itshop.service;

import hr.fer.zavrsni1500.itshop.dto.CountDto;
import hr.fer.zavrsni1500.itshop.dto.PCPartDto;
import hr.fer.zavrsni1500.itshop.dto.TypeDto;
import hr.fer.zavrsni1500.itshop.dto.filter.PCPartFilter;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PCPartService {
    PCPartDto getPCPartById(Long id);
    List<PCPartDto> getAllPCParts(Pageable pageable, PCPartFilter filter);
    CountDto getAllPCPartCount(PCPartFilter filter);
    PCPartDto createPCPart(PCPartDto pcPartDto, MultipartFile image) throws IOException;
    PCPartDto updatePCPart(Long id, PCPartDto pcPartDto, MultipartFile image) throws IOException;
    void deletePCPart(Long id);
    List<PCPartDto> get5MostVisited();
    List<TypeDto> getPCPartTypes();
    TypeDto createPCPartType(TypeDto pcPartTypeDto);
    void deletePCPartType(Long id);
}
