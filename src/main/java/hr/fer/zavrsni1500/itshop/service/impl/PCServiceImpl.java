package hr.fer.zavrsni1500.itshop.service.impl;

import hr.fer.zavrsni1500.itshop.dto.PCDto;
import hr.fer.zavrsni1500.itshop.model.PC;
import hr.fer.zavrsni1500.itshop.repository.PCRepository;
import hr.fer.zavrsni1500.itshop.service.PCService;
import hr.fer.zavrsni1500.itshop.util.mapper.PCMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PCServiceImpl implements PCService {

    private final PCRepository pcRepository;
    private final PCMapper pcMapper;

    public PCDto getPCById(Long id) {
        return pcMapper.pcToPcDto(pcRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Product with ID(%d) not found!", id))));
    }

    public List<PCDto> getAllPCs() {
        return pcMapper.pcsToPcDtos(pcRepository.findAll());
    }

    public PCDto createPC(PCDto pcDto) {
        PC pc = pcMapper.pcDtoToPc(pcDto);
        return pcMapper.pcToPcDto(pcRepository.save(pc));
    }

    public PCDto updatePC(Long id, PCDto updatePCdto) {
        PC pc = pcRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("PC with ID(%d) not found!", id)));

        PC updatePC = pcMapper.pcDtoToPc(updatePCdto);
        updatePC.setId(pc.getId());

        return pcMapper.pcToPcDto(pcRepository.save(updatePC));
    }

    public void deletePC(Long id) {
        PC pc = pcRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("PC with ID(%d) not found!", id)));
        pcRepository.delete(pc);
    }
}
