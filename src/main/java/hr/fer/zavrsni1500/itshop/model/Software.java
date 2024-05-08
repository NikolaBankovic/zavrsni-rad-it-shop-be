package hr.fer.zavrsni1500.itshop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Software extends Product{

    @Enumerated(EnumType.STRING)
    private SoftwareType softwareType;

}
