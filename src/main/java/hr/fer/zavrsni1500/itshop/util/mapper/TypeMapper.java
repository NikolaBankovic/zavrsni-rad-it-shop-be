package hr.fer.zavrsni1500.itshop.util.mapper;

import hr.fer.zavrsni1500.itshop.dto.TypeDto;
import hr.fer.zavrsni1500.itshop.model.PCPartType;
import hr.fer.zavrsni1500.itshop.model.PCType;
import hr.fer.zavrsni1500.itshop.model.PeripheralType;
import hr.fer.zavrsni1500.itshop.model.SoftwareType;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TypeMapper {
    TypeDto pcPartTypeToTypeDto(PCPartType pcPartType);
    TypeDto PCTypeToTypeDto(PCType pcType);
    TypeDto peripheralTypeToTypeDto(PeripheralType peripheralType);
    TypeDto softwareTypeToTypeDto(SoftwareType softwareType);
    List<TypeDto> pcPartTypeListToTypeDtoList(List<PCPartType> pcPartTypes);
    List<TypeDto> PCTypeListToTypeDtoList(List<PCType> pcTypes);
    List<TypeDto> peripheralTypeListToTypeDtoList(List<PeripheralType> peripheralTypes);
    List<TypeDto> softwareTypeListToTypeDtoList(List<SoftwareType> softwareTypes);

    PCPartType typeDtoToPCPartType(TypeDto typeDto);
    PCType typeDtoToPCType(TypeDto typeDto);
    PeripheralType typeDtoToPeripheralType(TypeDto typeDto);
    SoftwareType typeDtoToSoftwareType(TypeDto typeDto);
    List<PCPartType> typeDtoToPCPartTypeList(List<TypeDto> typeDtos);
    List<PCType> typeDtoToPCTypeList(List<TypeDto> typeDtos);
    List<PeripheralType> typeDtoToPeripheralTypeList(List<TypeDto> typeDtos);
    List<SoftwareType> typeDtoToSoftwareTypeList(List<TypeDto> typeDtos);
}
