package hr.fer.zavrsni1500.itshop.controller;

import hr.fer.zavrsni1500.itshop.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/codebook")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_USER')")
public class CodebookController {

    @GetMapping("/product-type")
    public List<String> productType() {
        return ProductType.getAllProductTypes();
    }

    @GetMapping("/pc-type")
    public List<String> pcType() {
        return Arrays.stream(PCType.values()).map(PCType::toString).toList();
    }

    @GetMapping("/pc-part-type")
    public List<String> pcPartType() {
        return Arrays.stream(PCPartType.values()).map(PCPartType::toString).toList();
    }

    @GetMapping("/peripheral-type")
    public List<String> peripheralType() {
        return Arrays.stream(PeripheralType.values()).map(PeripheralType::toString).toList();
    }

    @GetMapping("/software-type")
    public List<String> softwareType() {
        return Arrays.stream(SoftwareType.values()).map(SoftwareType::toString).toList();
    }

    @GetMapping("/used-state")
    public List<String> usedState() {
        return Arrays.stream(UsedState.values()).map(UsedState::toString).toList();
    }

}
