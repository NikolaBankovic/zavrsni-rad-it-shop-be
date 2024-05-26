package hr.fer.zavrsni1500.itshop.dto;

public record PCDto(
        Long id,
        String name,
        double price,
        String description,
        String cpu,
        String motherboard,
        String gpu,
        String ram,
        String storage,
        String psu,
        String pcCase,
        String cpuCooler,
        String opticalDrive,
        String fans,
        String accessories
) {
}


