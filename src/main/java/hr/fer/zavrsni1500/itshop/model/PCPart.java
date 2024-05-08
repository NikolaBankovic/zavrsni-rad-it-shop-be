package hr.fer.zavrsni1500.itshop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PCPart extends Product{

    @Enumerated(EnumType.STRING)
    private PCPartType pcPartType;

    @Enumerated(EnumType.STRING)
    private UsedState usedState;

    private Long warrantyLength;

    private String manufacturerName;

    private String manufacturerCatalogueNumber;

    private String linkToPartOnManufacturerWebsite;

}
