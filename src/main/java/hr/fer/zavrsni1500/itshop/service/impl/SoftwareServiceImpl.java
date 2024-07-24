package hr.fer.zavrsni1500.itshop.service.impl;

import hr.fer.zavrsni1500.itshop.dto.CountDto;
import hr.fer.zavrsni1500.itshop.dto.SoftwareDto;
import hr.fer.zavrsni1500.itshop.dto.TypeDto;
import hr.fer.zavrsni1500.itshop.model.Software;
import hr.fer.zavrsni1500.itshop.dto.filter.SoftwareFilter;
import hr.fer.zavrsni1500.itshop.model.SoftwareType;
import hr.fer.zavrsni1500.itshop.repository.SoftwareRepository;
import hr.fer.zavrsni1500.itshop.repository.SoftwareTypeRepository;
import hr.fer.zavrsni1500.itshop.repository.specification.SoftwareSpecification;
import hr.fer.zavrsni1500.itshop.service.SoftwareService;
import hr.fer.zavrsni1500.itshop.util.mapper.SoftwareMapper;
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
public class SoftwareServiceImpl implements SoftwareService {

    private final SoftwareRepository softwareRepository;
    private final SoftwareTypeRepository softwareTypeRepository;
    private final SoftwareMapper softwareMapper;
    private final TypeMapper typeMapper;

    public SoftwareDto getSoftwareById(final Long id) {
        return softwareMapper.softwareToSoftwareDto(softwareRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Software with ID(%d) not found!", id))));
    }

    public List<SoftwareDto> getAllSoftware(final Pageable pageable, final SoftwareFilter filter) {
        final SoftwareSpecification specification = new SoftwareSpecification(filter);
        return softwareMapper.softwaresToSoftwaresDto(softwareRepository.findAll(specification, pageable));
    }

    public CountDto getAllSoftwareCount(final SoftwareFilter filter) {
        final SoftwareSpecification specification = new SoftwareSpecification(filter);
        return new CountDto(softwareRepository.count(specification));
    }

    public SoftwareDto createSoftware(final SoftwareDto softwareDto, final MultipartFile image) throws IOException {
        final Software software = softwareMapper.softwareDtoToSoftware(softwareDto);
        software.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
        return softwareMapper.softwareToSoftwareDto(softwareRepository.save(software));
    }

    public SoftwareDto updateSoftware(final Long id, final SoftwareDto softwareDto, final MultipartFile image) throws IOException {
        final Software software = softwareRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Software with ID(%d) not found!", id)));

        final Software updatedSoftware = softwareMapper.softwareDtoToSoftware(softwareDto);
        updatedSoftware.setImage(software.getImage());
        if(image != null && !image.isEmpty()) {
            updatedSoftware.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
        }
        updatedSoftware.setId(software.getId());

        return softwareMapper.softwareToSoftwareDto(softwareRepository.save(updatedSoftware));
    }

    public void deleteSoftware(final Long id) {
        final Software software = softwareRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Software with ID(%d) not found!", id)));
        softwareRepository.delete(software);
    }

    public List<SoftwareDto> get5MostVisited() {
        return softwareMapper.softwaresToSoftwaresDto(softwareRepository.findTop5ByTimesVisited());
    }

    public List<TypeDto> getSoftwareTypes() {
        final List<SoftwareType> softwareTypes = softwareTypeRepository.findAll();

        return typeMapper.softwareTypeListToTypeDtoList(softwareTypes);
    }

    public TypeDto createSoftwareType(final TypeDto softwareTypeDto) {
        final SoftwareType softwareType = typeMapper.typeDtoToSoftwareType(softwareTypeDto);

        return typeMapper.softwareTypeToTypeDto(softwareTypeRepository.save(softwareType));
    }
}
