package hr.fer.zavrsni1500.itshop.util.mapper;

import hr.fer.zavrsni1500.itshop.dto.SoftwareDto;
import hr.fer.zavrsni1500.itshop.model.Software;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SoftwareMapper {
    SoftwareDto softwareToSoftwareDto(Software software);
    Software softwareDtoToSoftware(SoftwareDto softwareDto);
    List<SoftwareDto> softwaresToSoftwaresDto(List<Software> softwareList);
    List<SoftwareDto> softwaresToSoftwaresDto(Page<Software> softwareList);
    List<Software> softwaresDtoToSoftwares(List<SoftwareDto> softwareDtoList);
}
