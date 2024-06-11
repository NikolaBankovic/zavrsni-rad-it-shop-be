package hr.fer.zavrsni1500.itshop.service.impl;

import hr.fer.zavrsni1500.itshop.dto.PCPartDto;
import hr.fer.zavrsni1500.itshop.model.PCPart;
import hr.fer.zavrsni1500.itshop.dto.filter.PCPartFilter;
import hr.fer.zavrsni1500.itshop.repository.PCPartRepository;
import hr.fer.zavrsni1500.itshop.repository.specification.PCPartSpecification;
import hr.fer.zavrsni1500.itshop.service.PCPartService;
import hr.fer.zavrsni1500.itshop.util.mapper.PCPartMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PCPartServiceImpl implements PCPartService {
    private final PCPartRepository pcPartRepository;
    private final PCPartMapper pcPartMapper;

    public PCPartDto getPCPartById(final Long id) {
        return pcPartMapper.pcPartToPCPartDto(pcPartRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("PC part with ID(%d) not found!", id))));
    }

    public List<PCPartDto> getAllPCParts(final PCPartFilter filter) {
        final PCPartSpecification specification = new PCPartSpecification(filter);
        return pcPartMapper.pcPartsToPCPartDtos(pcPartRepository.findAll(specification));
    }

    public PCPartDto createPCPart(final PCPartDto pcPartDto, final MultipartFile image) throws IOException {
        final PCPart pcPart = pcPartMapper.pcPartDtoToPCPart(pcPartDto);
        pcPart.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
        return pcPartMapper.pcPartToPCPartDto(pcPartRepository.save(pcPart));
    }

    public PCPartDto updatePCPart(final Long id, final PCPartDto pcPartDto, final MultipartFile image) throws IOException {
        final PCPart pcPart = pcPartRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("PC part with ID(%d) not found!", id)));

        final PCPart updatePCPart = pcPartMapper.pcPartDtoToPCPart(pcPartDto);
        updatePCPart.setImage(pcPart.getImage());
        if(image != null && !image.isEmpty()) {
            updatePCPart.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
        }
        updatePCPart.setId(pcPart.getId());

        return pcPartMapper.pcPartToPCPartDto(pcPartRepository.save(updatePCPart));
    }

    public void deletePCPart(final Long id) {
        final PCPart pcPart = pcPartRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("PC part with ID(%d) not found!", id)));
        pcPartRepository.delete(pcPart);
    }

    public List<PCPartDto> get5MostVisited() {
        return pcPartMapper.pcPartsToPCPartDtos(pcPartRepository.findTop5ByTimesVisited());
    }
}
