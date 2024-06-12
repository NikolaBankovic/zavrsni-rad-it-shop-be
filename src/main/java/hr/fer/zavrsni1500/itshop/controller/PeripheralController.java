package hr.fer.zavrsni1500.itshop.controller;

import hr.fer.zavrsni1500.itshop.dto.CountDto;
import hr.fer.zavrsni1500.itshop.dto.PeripheralDto;
import hr.fer.zavrsni1500.itshop.dto.filter.PeripheralFilter;
import hr.fer.zavrsni1500.itshop.service.PeripheralService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public List<PeripheralDto> getAllPeripherals(final Pageable pageable, final PeripheralFilter filter) {
        return peripheralService.getAllPeripherals(pageable, filter);
    }

    @GetMapping("/all/count")
    public CountDto getAllPeripheralCount(final PeripheralFilter filter) {
        return peripheralService.getAllPeripheralCount(filter);
    }

    @GetMapping("/top")
    public List<PeripheralDto> get5MostVisited() {
        return peripheralService.get5MostVisited();
    }

    @PostMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public PeripheralDto createPeripheral(
            @RequestPart("peripheralDto") final PeripheralDto peripheralDto,
            @RequestPart(value = "image", required = false) final MultipartFile image) throws IOException {
        return peripheralService.createPeripheral(peripheralDto, image);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public PeripheralDto updatePeripheral(
            @PathVariable final Long id,
            @RequestPart("peripheralDto") final PeripheralDto peripheralDto,
            @RequestPart(value = "image", required = false) final MultipartFile image) throws IOException {
        return peripheralService.updatePeripheral(id, peripheralDto, image);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deletePeripheral(@PathVariable final Long id) {
        peripheralService.deletePeripheral(id);
    }
}