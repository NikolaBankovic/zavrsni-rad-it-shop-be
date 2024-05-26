package hr.fer.zavrsni1500.itshop.util.mapper;

import hr.fer.zavrsni1500.itshop.dto.PeripheralDto;
import hr.fer.zavrsni1500.itshop.model.Peripheral;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PeripheralMapper {
    PeripheralDto peripheralToPeripheralDto(Peripheral peripheral);
    Peripheral peripheralDtoToPeripheral(PeripheralDto dto);
    List<PeripheralDto> peripheralsToPeripheralDtos(List<Peripheral> peripherals);
    List<Peripheral> peripheralDtosToPeripherals(List<PeripheralDto> dtos);
}
