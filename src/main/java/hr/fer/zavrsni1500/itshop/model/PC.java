package hr.fer.zavrsni1500.itshop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue(ProductType.PC)
public class PC extends Product{

    @ManyToOne
    @JoinColumn(name = "pc_type_id")
    private PCType pcType;

}
