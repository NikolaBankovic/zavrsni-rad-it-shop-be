package hr.fer.zavrsni1500.itshop.model;

import lombok.Getter;

@Getter
public enum PeripheralType {
    KEYBOARD("Tipkovnica"),
    MOUSE("Miš"),
    MOUSE_MAT("Podloga za miš"),
    SPEAKERS("Zvučnici"),
    HEADPHONES("Slušalice"),
    MICROPHONE("Mikrofon"),
    WEB_CAM("Web kamera"),
    MONITOR("Monitor"),
    CABLE("Kabel"),
    ADAPTER("Adapter");

    private final String peripheralType;

    PeripheralType(String peripheralType) {
        this.peripheralType = peripheralType;
    }
}
