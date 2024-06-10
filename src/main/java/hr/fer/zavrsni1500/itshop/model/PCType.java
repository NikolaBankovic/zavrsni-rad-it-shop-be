package hr.fer.zavrsni1500.itshop.model;

import lombok.Getter;

@Getter
public enum PCType {
    OFFICE("Uredski"),
    GAMING("Za igranje"),
    WORK_STATION("Radna stanica"),
    SERVER("Poslužitelj");

    private final String pcTypeName;

    PCType(final String pcTypeName) {
        this.pcTypeName = pcTypeName;
    }
}
