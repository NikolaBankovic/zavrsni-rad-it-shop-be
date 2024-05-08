package hr.fer.zavrsni1500.itshop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Peripheral extends Product{

    @Enumerated(EnumType.STRING)
    private PeripheralType peripheralType;
}
