package hr.fer.zavrsni1500.itshop.controller;

import hr.fer.zavrsni1500.itshop.dto.SoftwareDto;
import hr.fer.zavrsni1500.itshop.service.SoftwareService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/software")
@RequiredArgsConstructor
public class SoftwareController {

    private final SoftwareService softwareService;

    @GetMapping("/{id}")
    public SoftwareDto getSoftwareById(@PathVariable final Long id) {
        return softwareService.getSoftwareById(id);
    }

    @GetMapping("/all")
    public List<SoftwareDto> getAllSoftwares() {
        return softwareService.getAllSoftwares();
    }

    @PostMapping()
    public SoftwareDto createSoftware(@RequestBody final SoftwareDto softwareDto) {
        return softwareService.createSoftware(softwareDto);
    }

    @PutMapping("/{id}")
    public SoftwareDto updateSoftware(@PathVariable final Long id, @RequestBody final SoftwareDto softwareDto) {
        return softwareService.updateSoftware(id, softwareDto);
    }

    @DeleteMapping("/{id}")
    public void deleteSoftware(@PathVariable final Long id) {
        softwareService.deleteSoftware(id);
    }
}
