package hr.fer.zavrsni1500.itshop.model;

import lombok.Getter;

@Getter
public enum SoftwareType {
    OS("Operacijski sustav"),
    APPLICATION("Aplikacija"),
    SECURITY("Sigurnost"),
    GAME("Igra");

    private final String softwareType;

    SoftwareType(String softwareType) {
        this.softwareType = softwareType;
    }
}
