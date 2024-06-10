package hr.fer.zavrsni1500.itshop.service;

import hr.fer.zavrsni1500.itshop.dto.PCPartDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PCPartService {
    PCPartDto getPCPartById(Long id);
    List<PCPartDto> getAllPCParts();
    PCPartDto createPCPart(PCPartDto pcPartDto, MultipartFile image) throws IOException;
    PCPartDto updatePCPart(Long id, PCPartDto pcPartDto, MultipartFile image) throws IOException;
    void deletePCPart(Long id);
}
