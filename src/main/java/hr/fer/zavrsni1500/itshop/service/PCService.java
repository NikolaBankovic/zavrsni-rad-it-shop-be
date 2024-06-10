package hr.fer.zavrsni1500.itshop.service;

import hr.fer.zavrsni1500.itshop.dto.PCDto;
import hr.fer.zavrsni1500.itshop.dto.filter.PCFilter;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PCService {

    PCDto getPCById(Long id);
    List<PCDto> getAllPCs(PCFilter filter);
    PCDto createPC(PCDto pcDto, MultipartFile image) throws IOException;
    PCDto updatePC(Long id, PCDto pcDto, MultipartFile image) throws IOException;
    void deletePC(Long id);
}
