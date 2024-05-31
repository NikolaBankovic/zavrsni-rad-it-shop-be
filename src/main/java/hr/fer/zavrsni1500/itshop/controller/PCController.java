package hr.fer.zavrsni1500.itshop.controller;

import hr.fer.zavrsni1500.itshop.dto.PCDto;
import hr.fer.zavrsni1500.itshop.service.PCService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
    public List<PCDto> getAllPCs() {
        return pcService.getAllPCs();
    }

    @PostMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public PCDto createPC(@RequestBody final PCDto pcDto) {
        return pcService.createPC(pcDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public PCDto updatePC(@PathVariable final Long id, @RequestBody final PCDto pcDto) {
        return pcService.updatePC(id, pcDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deletePC(@PathVariable final Long id) {
        pcService.deletePC(id);
    }
}
