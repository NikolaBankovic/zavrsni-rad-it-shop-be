package hr.fer.zavrsni1500.itshop.service;

import hr.fer.zavrsni1500.itshop.dto.PeripheralDto;

import java.util.List;

public interface PeripheralService {
    PeripheralDto getPeripheralById(Long id);
    List<PeripheralDto> getAllPeripherals();
    PeripheralDto createPeripheral(PeripheralDto peripheralDto);
    PeripheralDto updatePeripheral(Long id, PeripheralDto peripheralDto);
    void deletePeripheral(Long id);
}
