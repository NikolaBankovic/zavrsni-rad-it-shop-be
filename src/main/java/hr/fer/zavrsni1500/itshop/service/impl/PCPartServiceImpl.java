package hr.fer.zavrsni1500.itshop.service.impl;

import hr.fer.zavrsni1500.itshop.dto.PCPartDto;
import hr.fer.zavrsni1500.itshop.model.PCPart;
import hr.fer.zavrsni1500.itshop.repository.PCPartRepository;
import hr.fer.zavrsni1500.itshop.service.PCPartService;
import hr.fer.zavrsni1500.itshop.util.mapper.PCPartMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PCPartServiceImpl implements PCPartService {
    private final PCPartRepository pcPartRepository;
    private final PCPartMapper pcPartMapper;

    public PCPartDto getPCPartById(Long id) {
        return pcPartMapper.pcPartToPCPartDto(pcPartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("PC part with ID(%d) not found!", id))));
    }

    public List<PCPartDto> getAllPCParts() {
        return pcPartMapper.pcPartsToPCPartDtos(pcPartRepository.findAll());
    }

    public PCPartDto createPCPart(PCPartDto pcPartDto) {
        PCPart pcPart = pcPartMapper.pcPartDtoToPCPart(pcPartDto);
        return pcPartMapper.pcPartToPCPartDto(pcPartRepository.save(pcPart));
    }

    public PCPartDto updatePCPart(Long id, PCPartDto pcPartDto) {
        PCPart pcPart = pcPartRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("PC part with ID(%d) not found!", id)));

        PCPart updatePCPart = pcPartMapper.pcPartDtoToPCPart(pcPartDto);
        updatePCPart.setId(pcPart.getId());

        return pcPartMapper.pcPartToPCPartDto(pcPartRepository.save(pcPart));
    }

    public void deletePCPart(Long id) {
        PCPart pcPart = pcPartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("PC part with ID(%d) not found!", id)));
        pcPartRepository.delete(pcPart);
    }
}
