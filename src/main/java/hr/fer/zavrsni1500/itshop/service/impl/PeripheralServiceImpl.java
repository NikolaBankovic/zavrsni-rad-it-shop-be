package hr.fer.zavrsni1500.itshop.service.impl;

import hr.fer.zavrsni1500.itshop.dto.PeripheralDto;
import hr.fer.zavrsni1500.itshop.model.Peripheral;
import hr.fer.zavrsni1500.itshop.repository.PeripheralRepository;
import hr.fer.zavrsni1500.itshop.service.PeripheralService;
import hr.fer.zavrsni1500.itshop.util.mapper.PeripheralMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PeripheralServiceImpl implements PeripheralService {

    private final PeripheralRepository peripheralRepository;
    private final PeripheralMapper peripheralMapper;

    public PeripheralDto getPeripheralById(Long id) {
        return peripheralMapper.peripheralToPeripheralDto(peripheralRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Peripheral with ID(%d) not found!", id))));
    }

    public List<PeripheralDto> getAllPeripherals() {
        return peripheralMapper.peripheralsToPeripheralDtos(peripheralRepository.findAll());
    }

    public PeripheralDto createPeripheral(PeripheralDto peripheralDto) {
        Peripheral peripheral = peripheralMapper.peripheralDtoToPeripheral(peripheralDto);
        return peripheralMapper.peripheralToPeripheralDto(peripheralRepository.save(peripheral));
    }

    public PeripheralDto updatePeripheral(Long id, PeripheralDto updatePeripheralDto) {
        Peripheral peripheral = peripheralRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Peripheral with ID(%d) not found!", id)));

        Peripheral updatePeripheral = peripheralMapper.peripheralDtoToPeripheral(updatePeripheralDto);
        updatePeripheral.setId(peripheral.getId());

        return peripheralMapper.peripheralToPeripheralDto(peripheralRepository.save(updatePeripheral));
    }

    public void deletePeripheral(Long id) {
        Peripheral peripheral = peripheralRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Peripheral with ID(%d) not found!", id)));
        peripheralRepository.delete(peripheral);
    }
}
