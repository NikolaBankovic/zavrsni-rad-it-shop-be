package hr.fer.zavrsni1500.itshop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue(ProductType.PERIPHERAL)
public class Peripheral extends Product{

    @Enumerated(EnumType.STRING)
    private PeripheralType peripheralType;
}
