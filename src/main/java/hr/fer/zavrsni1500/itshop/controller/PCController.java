package hr.fer.zavrsni1500.itshop.controller;

import hr.fer.zavrsni1500.itshop.dto.CountDto;
import hr.fer.zavrsni1500.itshop.dto.PCDto;
import hr.fer.zavrsni1500.itshop.dto.filter.PCFilter;
import hr.fer.zavrsni1500.itshop.service.PCService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/pc")
@RequiredArgsConstructor
public class PCController {

    private final PCService pcService;

    @GetMapping("/{id}")
    public PCDto getPCById(@PathVariable final Long id) {
        return pcService.getPCById(id);
    }

    @GetMapping("/all")
    public List<PCDto> getAllPCs(final Pageable pageable, final PCFilter filter) {
        return pcService.getAllPCs(pageable, filter);
    }

    @GetMapping("/all/count")
    public CountDto getAllPCCount(final PCFilter filter) {
        return pcService.getAllPCCount(filter);
    }

    @GetMapping("/top")
    public List<PCDto> get5MostVisited() {
        return pcService.get5MostVisited();
    }

    @PostMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public PCDto createPC(@RequestPart("pcDto") final PCDto pcDto,
                          @RequestPart(value = "image", required = false) final MultipartFile image) throws IOException {

        return pcService.createPC(pcDto, image);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public PCDto updatePC(@PathVariable final Long id,
                          @RequestPart("pcDto") final PCDto pcDto,
                          @RequestPart(value = "image", required = false) final MultipartFile image) throws IOException {
        return pcService.updatePC(id, pcDto, image);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deletePC(@PathVariable final Long id) {
        pcService.deletePC(id);
    }

}
