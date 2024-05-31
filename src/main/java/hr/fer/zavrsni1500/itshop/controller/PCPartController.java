package hr.fer.zavrsni1500.itshop.controller;

import hr.fer.zavrsni1500.itshop.dto.PCPartDto;
import hr.fer.zavrsni1500.itshop.service.PCPartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pcpart")
@RequiredArgsConstructor
public class PCPartController {

    private final PCPartService pcPartService;

    @GetMapping("/{id}")
    public PCPartDto getPCPartById(@PathVariable final Long id) {
        return pcPartService.getPCPartById(id);
    }

    @GetMapping("/all")
    public List<PCPartDto> getAllPCParts() {
        return pcPartService.getAllPCParts();
    }

    @PostMapping()
    public PCPartDto createPCPart(@RequestBody final PCPartDto pcPartDto) {
        return pcPartService.createPCPart(pcPartDto);
    }

    @PutMapping("/{id}")
    public PCPartDto updatePCPart(@PathVariable final Long id, @RequestBody final PCPartDto pcPartDto) {
        return pcPartService.updatePCPart(id, pcPartDto);
    }

    @DeleteMapping("/{id}")
    public void deletePCPart(@PathVariable final Long id) {
        pcPartService.deletePCPart(id);
    }
}
