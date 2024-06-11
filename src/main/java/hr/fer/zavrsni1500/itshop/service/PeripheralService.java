package hr.fer.zavrsni1500.itshop.service;

import hr.fer.zavrsni1500.itshop.dto.PeripheralDto;
import hr.fer.zavrsni1500.itshop.dto.filter.PeripheralFilter;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PeripheralService {
    PeripheralDto getPeripheralById(Long id);
    List<PeripheralDto> getAllPeripherals(PeripheralFilter filter);
    PeripheralDto createPeripheral(PeripheralDto peripheralDto, MultipartFile image) throws IOException;
    PeripheralDto updatePeripheral(Long id, PeripheralDto peripheralDto, MultipartFile image) throws IOException;
    void deletePeripheral(Long id);
    List<PeripheralDto> get5MostVisited();
}
