package hr.fer.zavrsni1500.itshop.dto.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class SoftwareFilter extends ProductFilter {

    private String softwareType;
}
