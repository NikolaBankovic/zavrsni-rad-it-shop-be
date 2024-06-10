package hr.fer.zavrsni1500.itshop.service.impl;

import hr.fer.zavrsni1500.itshop.dto.SoftwareDto;
import hr.fer.zavrsni1500.itshop.model.Software;
import hr.fer.zavrsni1500.itshop.dto.filter.SoftwareFilter;
import hr.fer.zavrsni1500.itshop.repository.SoftwareRepository;
import hr.fer.zavrsni1500.itshop.repository.specification.SoftwareSpecification;
import hr.fer.zavrsni1500.itshop.service.SoftwareService;
import hr.fer.zavrsni1500.itshop.util.mapper.SoftwareMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SoftwareServiceImpl implements SoftwareService {

    private final SoftwareRepository softwareRepository;
    private final SoftwareMapper softwareMapper;

    public SoftwareDto getSoftwareById(final Long id) {
        return softwareMapper.softwareToSoftwareDto(softwareRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Software with ID(%d) not found!", id))));
    }

    public List<SoftwareDto> getAllSoftwares(final SoftwareFilter filter) {
        final SoftwareSpecification specification = new SoftwareSpecification(filter);
        return softwareMapper.softwaresToSoftwaresDto(softwareRepository.findAll(specification));
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
        if(!image.isEmpty()) {
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
}
