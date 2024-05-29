package hr.fer.zavrsni1500.itshop.service.impl;

import hr.fer.zavrsni1500.itshop.dto.SoftwareDto;
import hr.fer.zavrsni1500.itshop.model.Software;
import hr.fer.zavrsni1500.itshop.repository.SoftwareRepository;
import hr.fer.zavrsni1500.itshop.service.SoftwareService;
import hr.fer.zavrsni1500.itshop.util.mapper.SoftwareMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SoftwareServiceImpl implements SoftwareService {

    private final SoftwareRepository softwareRepository;
    private final SoftwareMapper softwareMapper;

    public SoftwareDto getSoftwareById(Long id) {
        return softwareMapper.softwareToSoftwareDto(softwareRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Software with ID(%d) not found!", id))));
    }

    public List<SoftwareDto> getAllSoftwares() {
        return softwareMapper.softwaresToSoftwaresDto(softwareRepository.findAll());
    }

    public SoftwareDto createSoftware(SoftwareDto softwareDto) {
        Software software = softwareMapper.softwareDtoToSoftware(softwareDto);
        return softwareMapper.softwareToSoftwareDto(softwareRepository.save(software));
    }

    public SoftwareDto updateSoftware(Long id, SoftwareDto softwareDto) {
        Software software = softwareRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Software with ID(%d) not found!", id)));

        Software updatedSoftware = softwareMapper.softwareDtoToSoftware(softwareDto);
        updatedSoftware.setId(software.getId());

        return softwareMapper.softwareToSoftwareDto(softwareRepository.save(updatedSoftware));
    }

    public void deleteSoftware(Long id) {
        Software software = softwareRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Software with ID(%d) not found!", id)));
        softwareRepository.delete(software);
    }
}
