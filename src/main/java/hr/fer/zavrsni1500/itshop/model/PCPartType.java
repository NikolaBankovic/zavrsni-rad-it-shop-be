package hr.fer.zavrsni1500.itshop.model;

import lombok.Getter;

@Getter
public enum PCPartType {

    PROCESSOR("Procesori"),
    MOTHERBOARD("Matične ploče"),
    GRAPHICS_CARD("Grafičke kartice"),
    RAM("Radna memorija (RAM)"),
    SSD("Solid state diskovi (SSD)"),
    HDD("Tvrdi diskovi (HDD)"),
    POWER_SUPPLY("Napajanja"),
    CASE("Kućišta"),
    COOLER("Cooleri"),
    LIQUID_COOLING("Vodeno hlađenje"),
    OPTICAL_DRIVE("Optički uređaji"),
    FAN("Ventilatori"),
    THERMAL_PASTE("Termalne paste"),
    AUDIO_CARD("Zvučne kartice");

    private final String partTypeName;

    PCPartType(final String partTypeName) {
        this.partTypeName = partTypeName;
    }

}
