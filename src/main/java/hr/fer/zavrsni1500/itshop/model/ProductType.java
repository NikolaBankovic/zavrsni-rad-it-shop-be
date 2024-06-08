package hr.fer.zavrsni1500.itshop.model;

import java.util.List;

public class ProductType {

    public static final String PC = "PC";
    public static final String PC_PART = "PC_PART";
    public static final String PERIPHERAL = "PERIPHERAL";
    public static final String SOFTWARE = "SOFTWARE";

    public static List<String> getAllProductTypes() {
        return List.of(PC, PC_PART, PERIPHERAL, SOFTWARE);
    }
}
