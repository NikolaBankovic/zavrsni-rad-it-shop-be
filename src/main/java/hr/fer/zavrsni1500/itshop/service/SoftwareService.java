package hr.fer.zavrsni1500.itshop.service;

import hr.fer.zavrsni1500.itshop.dto.CountDto;
import hr.fer.zavrsni1500.itshop.dto.SoftwareDto;
import hr.fer.zavrsni1500.itshop.dto.filter.SoftwareFilter;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface SoftwareService {
    SoftwareDto createSoftware(SoftwareDto softwareDto, MultipartFile image) throws IOException;
    SoftwareDto updateSoftware(Long id, SoftwareDto softwareDto, MultipartFile image) throws IOException;
    SoftwareDto getSoftwareById(Long id);
    List<SoftwareDto> getAllSoftware(Pageable pageable, SoftwareFilter filter);
    CountDto getAllSoftwareCount(SoftwareFilter filter);
    void deleteSoftware(Long id);
    List<SoftwareDto> get5MostVisited();
}
