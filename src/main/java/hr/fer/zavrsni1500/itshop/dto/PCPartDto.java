package hr.fer.zavrsni1500.itshop.dto;

import hr.fer.zavrsni1500.itshop.model.PCPartType;
import hr.fer.zavrsni1500.itshop.model.UsedState;

public record PCPartDto(
        Long id,
        String name,
        double price,
        String description,
        PCPartType pcPartType,
        UsedState usedState,
        Long warrantyLength,
        String manufacturerName,
        String manufacturerCatalogueNumber,
        String linkToPartOnManufacturerWebsite
) {
}
