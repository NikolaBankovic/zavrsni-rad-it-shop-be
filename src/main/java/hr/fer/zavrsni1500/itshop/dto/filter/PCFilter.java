package hr.fer.zavrsni1500.itshop.dto.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class PCFilter extends ProductFilter {

    private String pcType;
}
