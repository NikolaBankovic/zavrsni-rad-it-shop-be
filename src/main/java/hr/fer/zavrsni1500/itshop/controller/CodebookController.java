package hr.fer.zavrsni1500.itshop.controller;

import hr.fer.zavrsni1500.itshop.dto.CategoryDto;
import hr.fer.zavrsni1500.itshop.dto.TypeDto;
import hr.fer.zavrsni1500.itshop.model.*;
import hr.fer.zavrsni1500.itshop.service.PCPartService;
import hr.fer.zavrsni1500.itshop.service.PCService;
import hr.fer.zavrsni1500.itshop.service.PeripheralService;
import hr.fer.zavrsni1500.itshop.service.SoftwareService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/codebook")
@RequiredArgsConstructor
public class CodebookController {

    private final PCService pcService;
    private final PCPartService pcPartService;
    private final PeripheralService peripheralService;
    private final SoftwareService softwareService;

    @GetMapping("/product-type")
    public List<String> productType() {
        return ProductType.getAllProductTypes();
    }

    @GetMapping("/pc-type")
    public List<TypeDto> pcType() {
        return pcService.getPCTypes();
    }

    @GetMapping("/pc-part-type")
    public List<TypeDto> pcPartType() {
        return pcPartService.getPCPartTypes();
    }

    @GetMapping("/peripheral-type")
    public List<TypeDto> peripheralType() {
        return peripheralService.getPeripheralTypes();
    }

    @GetMapping("/software-type")
    public List<TypeDto> softwareType() {
        return softwareService.getSoftwareTypes();
    }

    @GetMapping("/used-state")
    public List<String> usedState() {
        return Arrays.stream(UsedState.values()).map(UsedState::toString).toList();
    }

    @GetMapping("/category")
    public List<CategoryDto> categories() {
        return ProductType.getAllProductTypes().stream()
                .map(productType ->
                    switch (productType) {
                        case ProductType.PC -> new CategoryDto(productType, pcType().stream().map(TypeDto::typeName).toList());
                        case ProductType.PC_PART -> new CategoryDto(productType, pcPartType().stream().map(TypeDto::typeName).toList());
                        case ProductType.PERIPHERAL -> new CategoryDto(productType, peripheralType().stream().map(TypeDto::typeName).toList());
                        case ProductType.SOFTWARE -> new CategoryDto(productType, softwareType().stream().map(TypeDto::typeName).toList());
                        default -> throw new IllegalStateException("Unexpected value: " + productType);
                    })
                .toList();
    }

    @PostMapping("/pc-type")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public TypeDto createPCType(@RequestBody final TypeDto typeDto) {
        return pcService.createPCType(typeDto);
    }

    @PostMapping("/pc-part-type")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public TypeDto createPCPartType(@RequestBody final TypeDto typeDto) {
        return pcPartService.createPCPartType(typeDto);
    }

    @PostMapping("/peripheral-type")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public TypeDto createPeripheralType(@RequestBody final TypeDto typeDto) {
        return peripheralService.createPeripheralType(typeDto);
    }

    @PostMapping("/software-type")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public TypeDto createSoftwareType(@RequestBody final TypeDto typeDto) {
        return softwareService.createSoftwareType(typeDto);
    }

    @DeleteMapping("/pc-type/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deletePCType(@PathVariable final Long id) {
        pcService.deletePCType(id);
    }

    @DeleteMapping("/pc-part-type/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deletePCPartType(@PathVariable final Long id) {
        pcPartService.deletePCPartType(id);
    }

    @DeleteMapping("/peripheral-type/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deletePeripheralType(@PathVariable final Long id) {
        peripheralService.deletePeripheralType(id);
    }

    @DeleteMapping("/software-type/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteSoftwareType(@PathVariable final Long id) {
        softwareService.deleteSoftwareType(id);
    }
}
