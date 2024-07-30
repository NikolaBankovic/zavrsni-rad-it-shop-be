package hr.fer.zavrsni1500.itshop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue(ProductType.PERIPHERAL)
public class Peripheral extends Product{

    @ManyToOne
    @JoinColumn(name = "peripheral_type_id")
    private PeripheralType peripheralType;
}
