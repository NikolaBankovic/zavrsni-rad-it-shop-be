package hr.fer.zavrsni1500.itshop.controller;

import hr.fer.zavrsni1500.itshop.dto.PeripheralDto;
import hr.fer.zavrsni1500.itshop.service.PeripheralService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peripheral")
@RequiredArgsConstructor
public class PeripheralController {

    private final PeripheralService peripheralService;

    @GetMapping("/{id}")
    public PeripheralDto getPeripheralById(@PathVariable final Long id) {
        return peripheralService.getPeripheralById(id);
    }

    @GetMapping("/all")
    public List<PeripheralDto> getAllPeripherals() {
        return peripheralService.getAllPeripherals();
    }

    @PostMapping()
    public PeripheralDto createPeripheral(@RequestBody final PeripheralDto peripheralDto) {
        return peripheralService.createPeripheral(peripheralDto);
    }

    @PutMapping("/{id}")
    public PeripheralDto updatePeripheral(@PathVariable final Long id, @RequestBody final PeripheralDto peripheralDto) {
        return peripheralService.updatePeripheral(id, peripheralDto);
    }

    @DeleteMapping("/{id}")
    public void deletePeripheral(@PathVariable final Long id) {
        peripheralService.deletePeripheral(id);
    }
}