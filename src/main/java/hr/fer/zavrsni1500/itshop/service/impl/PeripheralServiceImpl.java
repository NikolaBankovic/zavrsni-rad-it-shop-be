package hr.fer.zavrsni1500.itshop.service.impl;

import hr.fer.zavrsni1500.itshop.dto.PeripheralDto;
import hr.fer.zavrsni1500.itshop.model.Peripheral;
import hr.fer.zavrsni1500.itshop.dto.filter.PeripheralFilter;
import hr.fer.zavrsni1500.itshop.repository.PeripheralRepository;
import hr.fer.zavrsni1500.itshop.repository.specification.PeripheralSpecification;
import hr.fer.zavrsni1500.itshop.service.PeripheralService;
import hr.fer.zavrsni1500.itshop.util.mapper.PeripheralMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PeripheralServiceImpl implements PeripheralService {

    private final PeripheralRepository peripheralRepository;
    private final PeripheralMapper peripheralMapper;

    public PeripheralDto getPeripheralById(final Long id) {
        return peripheralMapper.peripheralToPeripheralDto(peripheralRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Peripheral with ID(%d) not found!", id))));
    }

    public List<PeripheralDto> getAllPeripherals(final PeripheralFilter filter) {
        final PeripheralSpecification specification = new PeripheralSpecification(filter);
        return peripheralMapper.peripheralsToPeripheralDtos(peripheralRepository.findAll(specification));
    }

    public PeripheralDto createPeripheral(final PeripheralDto peripheralDto, final MultipartFile image) throws IOException {
        final Peripheral peripheral = peripheralMapper.peripheralDtoToPeripheral(peripheralDto);
        peripheral.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
        return peripheralMapper.peripheralToPeripheralDto(peripheralRepository.save(peripheral));
    }

    public PeripheralDto updatePeripheral(final Long id,
                                          final PeripheralDto updatePeripheralDto,
                                          final MultipartFile image) throws IOException {
        final Peripheral peripheral = peripheralRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Peripheral with ID(%d) not found!", id)));

        final Peripheral updatePeripheral = peripheralMapper.peripheralDtoToPeripheral(updatePeripheralDto);
        updatePeripheral.setImage(peripheral.getImage());
        if(image != null && !image.isEmpty()) {
            updatePeripheral.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
        }
        updatePeripheral.setId(peripheral.getId());

        return peripheralMapper.peripheralToPeripheralDto(peripheralRepository.save(updatePeripheral));
    }

    public void deletePeripheral(final Long id) {
        final Peripheral peripheral = peripheralRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Peripheral with ID(%d) not found!", id)));
        peripheralRepository.delete(peripheral);
    }

    public List<PeripheralDto> get5MostVisited() {
        return peripheralMapper.peripheralsToPeripheralDtos(peripheralRepository.findTop5ByTimesVisited());
    }
}
