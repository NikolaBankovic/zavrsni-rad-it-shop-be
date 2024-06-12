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
                    pc.getId().intValue(),
                    ProductType.PC,
                    pc.getName(),
                    pc.getPrice(),
                    pc.getDescription(),
                    pc.getImage(),
                    pc.getTimesVisited(),
                    pc.getPcType(),
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null
            );
            case final PCPart pcPart -> new ProductDto(
                    pcPart.getId().intValue(),
                    ProductType.PC_PART,
                    pcPart.getName(),
                    pcPart.getPrice(),
                    pcPart.getDescription(),
                    pcPart.getImage(),
                    pcPart.getTimesVisited(),
                    null,
                    pcPart.getPcPartType(),
                    null,
                    null,
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
                    peripheral.getTimesVisited(),
                    null,
                    null,
                    peripheral.getPeripheralType(),
                    null,
                    null,
                    null,
                    null,
                    null,
                    null
            );
            case final Software software -> new ProductDto(
                    software.getId().intValue(),
                    ProductType.SOFTWARE,
                    software.getName(),
                    software.getPrice(),
                    software.getDescription(),
                    software.getImage(),
                    software.getTimesVisited(),
                    null,
                    null,
                    null,
                    software.getSoftwareType(),
                    null,
                    null,
                    null,
                    null,
                    null
            );
            case null, default ->
                    new ProductDto(
                            product.getId().intValue(),
                            null,
                            product.getName(),
                            product.getPrice(),
                            product.getDescription(),
                            product.getImage(),
                            product.getTimesVisited(),
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null
                    );
        };
    }

    List<ProductDto> productsToProductDtos(List<Product> products);
}
