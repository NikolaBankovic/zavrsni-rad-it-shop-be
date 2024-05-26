package hr.fer.zavrsni1500.itshop.controller;

import hr.fer.zavrsni1500.itshop.dto.PCDto;
import hr.fer.zavrsni1500.itshop.service.PCService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pc")
@RequiredArgsConstructor
public class PCController {

    private final PCService pcService;

    @GetMapping("/{id}")
    public PCDto getPCById(@PathVariable Long id) {
        return pcService.getPCById(id);
    }

    @GetMapping("/all")
    public List<PCDto> getAllPCs() {
        return pcService.getAllPCs();
    }

    @PostMapping()
    public PCDto createPC(@RequestBody PCDto pcDto) {
        return pcService.createPC(pcDto);
    }

    @PutMapping("/{id}")
    public PCDto updatePC(@PathVariable Long id, @RequestBody PCDto pcDto) {
        return pcService.updatePC(id, pcDto);
    }

    @DeleteMapping("/{id}")
    public void deletePC(@PathVariable Long id) {
        pcService.deletePC(id);
    }
}
