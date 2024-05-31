package hr.fer.zavrsni1500.itshop.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue(ProductType.PC)
public class PC extends Product{

    private PCType pcType;

}
