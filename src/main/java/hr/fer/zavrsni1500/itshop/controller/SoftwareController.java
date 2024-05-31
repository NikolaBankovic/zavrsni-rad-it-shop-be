package hr.fer.zavrsni1500.itshop.controller;

import hr.fer.zavrsni1500.itshop.dto.SoftwareDto;
import hr.fer.zavrsni1500.itshop.service.SoftwareService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public SoftwareDto createSoftware(@RequestPart("softwareDto") final SoftwareDto softwareDto,
                                      @RequestPart(value = "image", required = false) final MultipartFile image) throws IOException {
        return softwareService.createSoftware(softwareDto, image);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public SoftwareDto updateSoftware(@PathVariable final Long id,
                                      @RequestPart("softwareDto") final SoftwareDto softwareDto,
                                      @RequestPart(value = "image", required = false) final MultipartFile image) throws IOException {
        return softwareService.updateSoftware(id, softwareDto, image);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteSoftware(@PathVariable final Long id) {
        softwareService.deleteSoftware(id);
    }
}
