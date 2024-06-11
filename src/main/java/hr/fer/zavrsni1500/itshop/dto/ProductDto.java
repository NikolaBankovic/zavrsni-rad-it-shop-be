package hr.fer.zavrsni1500.itshop.dto;

import hr.fer.zavrsni1500.itshop.model.*;

public record ProductDto(
        int id,
        String productType,
        String name,
        double price,
        String description,
        String image,
        long timesVisited,
        PCType pcType,
        PCPartType pcPartType,
        PeripheralType peripheralType,
        SoftwareType softwareType,
        UsedState usedState,
        Integer warrantyLength,
        String manufacturerName,
        String manufacturerCatalogueNumber,
        String linkToPartOnManufacturerWebsite
) {
}
