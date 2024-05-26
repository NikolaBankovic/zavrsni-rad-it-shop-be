package hr.fer.zavrsni1500.itshop.util.mapper;

import hr.fer.zavrsni1500.itshop.dto.PCDto;
import hr.fer.zavrsni1500.itshop.model.PC;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PCMapper {
    PCDto pcToPcDto(PC pc);
    PC pcDtoToPc(PCDto pcDto);
    List<PCDto> pcsToPcDtos(List<PC> pcs);
    List<PC> pcDtosToPcs(List<PCDto> pcDtos);
}
