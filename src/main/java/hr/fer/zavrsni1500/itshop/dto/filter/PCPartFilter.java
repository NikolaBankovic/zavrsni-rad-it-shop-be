package hr.fer.zavrsni1500.itshop.dto.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class PCPartFilter extends ProductFilter {

    private String pcPartType;
    private String usedState;
    private Long warrantyLength;
    private String manufacturerName;
    private String manufacturerCatalogueNumber;
}
