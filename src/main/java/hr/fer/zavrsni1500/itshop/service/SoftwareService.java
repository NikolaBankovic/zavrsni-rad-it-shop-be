package hr.fer.zavrsni1500.itshop.service;

import hr.fer.zavrsni1500.itshop.dto.SoftwareDto;

import java.util.List;

public interface SoftwareService {
    SoftwareDto createSoftware(SoftwareDto softwareDto);
    SoftwareDto updateSoftware(Long id, SoftwareDto softwareDto);
    SoftwareDto getSoftwareById(Long id);
    List<SoftwareDto> getAllSoftwares();
    void deleteSoftware(Long id);
}
