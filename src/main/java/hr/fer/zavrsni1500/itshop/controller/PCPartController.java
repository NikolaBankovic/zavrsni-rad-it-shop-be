package hr.fer.zavrsni1500.itshop.controller;

import hr.fer.zavrsni1500.itshop.dto.PCPartDto;
import hr.fer.zavrsni1500.itshop.dto.filter.PCPartFilter;
import hr.fer.zavrsni1500.itshop.service.PCPartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/pc-part")
@RequiredArgsConstructor
public class PCPartController {

    private final PCPartService pcPartService;

    @GetMapping("/{id}")
    public PCPartDto getPCPartById(@PathVariable final Long id) {
        return pcPartService.getPCPartById(id);
    }

    @GetMapping("/all")
    public List<PCPartDto> getAllPCParts(final PCPartFilter filter) {
        return pcPartService.getAllPCParts(filter);
    }

    @PostMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public PCPartDto createPCPart(@RequestPart("pcPartDto") final PCPartDto pcPartDto,
                                  @RequestPart(value = "image", required = false) final MultipartFile image) throws IOException {

        return pcPartService.createPCPart(pcPartDto, image);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public PCPartDto updatePCPart(@PathVariable final Long id,
                                  @RequestPart("pcPartDto") final PCPartDto pcPartDto,
                                  @RequestPart(value = "image", required = false) final MultipartFile image) throws IOException {
        return pcPartService.updatePCPart(id, pcPartDto, image);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deletePCPart(@PathVariable final Long id) {
        pcPartService.deletePCPart(id);
    }
}
