package hr.fer.zavrsni1500.itshop.util.mapper;

import hr.fer.zavrsni1500.itshop.dto.PCPartDto;
import hr.fer.zavrsni1500.itshop.model.PCPart;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PCPartMapper {
    PCPartDto pcPartToPCPartDto(PCPart pcPart);
    PCPart pcPartDtoToPCPart(PCPartDto pcPartDto);
    List<PCPartDto> pcPartsToPCPartDtos(List<PCPart> pcs);
    List<PCPartDto> pcPartsToPCPartDtos(Page<PCPart> pcs);
    List<PCPart> pcPartDtosToPCParts(List<PCPartDto> pcPartDtos);
}
