package hr.fer.zavrsni1500.itshop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Float price;

    private String manufacturerName;

    private String manufacturerCatalogueNumber;

    private String linkToPartOnManufacturerWebsite;
}