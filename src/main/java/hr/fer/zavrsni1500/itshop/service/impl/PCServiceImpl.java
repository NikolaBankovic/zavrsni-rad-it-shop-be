package hr.fer.zavrsni1500.itshop.service.impl;

import hr.fer.zavrsni1500.itshop.dto.CountDto;
import hr.fer.zavrsni1500.itshop.dto.PCDto;
import hr.fer.zavrsni1500.itshop.dto.TypeDto;
import hr.fer.zavrsni1500.itshop.dto.filter.PCFilter;
import hr.fer.zavrsni1500.itshop.model.PC;
import hr.fer.zavrsni1500.itshop.model.PCType;
import hr.fer.zavrsni1500.itshop.repository.PCRepository;
import hr.fer.zavrsni1500.itshop.repository.PCTypeRepository;
import hr.fer.zavrsni1500.itshop.repository.specification.PCSpecification;
import hr.fer.zavrsni1500.itshop.service.PCService;
import hr.fer.zavrsni1500.itshop.util.mapper.PCMapper;
import hr.fer.zavrsni1500.itshop.util.mapper.TypeMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PCServiceImpl implements PCService {

    private final PCRepository pcRepository;
    private final PCTypeRepository pcTypeRepository;
    private final PCMapper pcMapper;
    private final TypeMapper typeMapper;

    public PCDto getPCById(final Long id) {
        return pcMapper.pcToPcDto(pcRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Product with ID(%d) not found!", id))));
    }

    public List<PCDto> getAllPCs(final Pageable pageable, final PCFilter filter) {
        final PCSpecification specification = new PCSpecification(filter);
        return pcMapper.pcsToPcDtos(pcRepository.findAll(specification, pageable));
    }

    public CountDto getAllPCCount(final PCFilter filter) {
        final PCSpecification specification = new PCSpecification(filter);
        return new CountDto(pcRepository.count(specification));
    }

    public PCDto createPC(final PCDto pcDto, final MultipartFile image) throws IOException {
        final PC pc = pcMapper.pcDtoToPc(pcDto);
        pc.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
        return pcMapper.pcToPcDto(pcRepository.save(pc));
    }

    public PCDto updatePC(final Long id, final PCDto updatePCdto, final MultipartFile image) throws IOException {
        final PC pc = pcRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("PC with ID(%d) not found!", id)));

        final PC updatePC = pcMapper.pcDtoToPc(updatePCdto);
        updatePC.setImage(pc.getImage());
        if(image != null && !image.isEmpty()) {
            updatePC.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
        }
        updatePC.setId(pc.getId());

        return pcMapper.pcToPcDto(pcRepository.save(updatePC));
    }

    public void deletePC(final Long id) {
        final PC pc = pcRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("PC with ID(%d) not found!", id)));
        pcRepository.delete(pc);
    }

    public List<PCDto> get5MostVisited() {
        return pcMapper.pcsToPcDtos(pcRepository.findTop5ByTimesVisited());
    }

    public List<TypeDto> getPCTypes() {
        final List<PCType> pcTypes = pcTypeRepository.findAll();

        return typeMapper.PCTypeListToTypeDtoList(pcTypes);
    }

    public TypeDto createPCType(final TypeDto pcTypeDto) {
        final PCType pcType = typeMapper.typeDtoToPCType(pcTypeDto);

        return typeMapper.PCTypeToTypeDto(pcTypeRepository.save(pcType));
    }

    public void deletePCType(final Long id) {
        final PCType pcType = pcTypeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("PC type with ID(%d) not found!", id)));
        pcTypeRepository.delete(pcType);
    }
}
