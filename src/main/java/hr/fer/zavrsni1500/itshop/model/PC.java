package hr.fer.zavrsni1500.itshop.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PC extends Product{

    private String cpu;

    private String motherboard;

    private String gpu;

    private String ram;

    private String storage;

    private String psu;

    private String pcCase;

    private String cpuCooler;

    private String opticalDrive;

    private String fans;

    private String accessories;

}
