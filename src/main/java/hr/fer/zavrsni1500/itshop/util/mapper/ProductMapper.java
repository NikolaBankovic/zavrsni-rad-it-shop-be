package hr.fer.zavrsni1500.itshop.util.mapper;

import hr.fer.zavrsni1500.itshop.dto.ProductDto;
import hr.fer.zavrsni1500.itshop.model.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    default ProductDto productToProductDto(final Product product) {
        return switch (product) {
            case final PC pc -> new ProductDto(
                    pc.getId().intValue(),  // assuming id in ProductDto is int
                    ProductType.PC,
                    pc.getName(),
                    pc.getPrice(),
                    pc.getDescription(),
                    pc.getImage(),
                    pc.getPcType(),
                    null,   // PCPartType
                    null,   // PeripheralType
                    null,   // SoftwareType
                    null,   // UsedState
                    null,   // warrantyLength
                    null,   // manufacturerName
                    null,   // manufacturerCatalogueNumber
                    null    // linkToPartOnManufacturerWebsite
            );
            case final PCPart pcPart -> new ProductDto(
                    pcPart.getId().intValue(),
                    ProductType.PC_PART,
                    pcPart.getName(),
                    pcPart.getPrice(),
                    pcPart.getDescription(),
                    pcPart.getImage(),
                    null,   // PCType
                    pcPart.getPcPartType(),
                    null,   // PeripheralType
                    null,   // SoftwareType
                    pcPart.getUsedState(),
                    pcPart.getWarrantyLength() != null ? pcPart.getWarrantyLength().intValue() : null,
                    pcPart.getManufacturerName(),
                    pcPart.getManufacturerCatalogueNumber(),
                    pcPart.getLinkToPartOnManufacturerWebsite()
            );
            case final Peripheral peripheral -> new ProductDto(
                    peripheral.getId().intValue(),
                    ProductType.PERIPHERAL,
                    peripheral.getName(),
                    peripheral.getPrice(),
                    peripheral.getDescription(),
                    peripheral.getImage(),
                    null,   // PCType
                    null,   // PCPartType
                    peripheral.getPeripheralType(),
                    null,   // SoftwareType
                    null,   // UsedState
                    null,   // warrantyLength
                    null,   // manufacturerName
                    null,   // manufacturerCatalogueNumber
                    null    // linkToPartOnManufacturerWebsite
            );
            case final Software software -> new ProductDto(
                    software.getId().intValue(),
                    ProductType.SOFTWARE,
                    software.getName(),
                    software.getPrice(),
                    software.getDescription(),
                    software.getImage(),
                    null,   // PCType
                    null,   // PCPartType
                    null,   // PeripheralType
                    software.getSoftwareType(),
                    null,   // UsedState
                    null,   // warrantyLength
                    null,   // manufacturerName
                    null,   // manufacturerCatalogueNumber
                    null    // linkToPartOnManufacturerWebsite
            );
            case null, default ->
                // Handle unknown product types or base Product class
                    new ProductDto(
                            product.getId().intValue(),
                            null,
                            product.getName(),
                            product.getPrice(),
                            product.getDescription(),
                            product.getImage(),
                            null,   // PCType
                            null,   // PCPartType
                            null,   // PeripheralType
                            null,   // SoftwareType
                            null,   // UsedState
                            null,   // warrantyLength
                            null,   // manufacturerName
                            null,   // manufacturerCatalogueNumber
                            null    // linkToPartOnManufacturerWebsite
                    );
        };
    }

    List<ProductDto> productsToProductDtos(List<Product> products);
}
