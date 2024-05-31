package hr.fer.zavrsni1500.itshop.service;

import hr.fer.zavrsni1500.itshop.dto.SoftwareDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface SoftwareService {
    SoftwareDto createSoftware(SoftwareDto softwareDto, MultipartFile image) throws IOException;
    SoftwareDto updateSoftware(Long id, SoftwareDto softwareDto, MultipartFile image) throws IOException;
    SoftwareDto getSoftwareById(Long id);
    List<SoftwareDto> getAllSoftwares();
    void deleteSoftware(Long id);
}
