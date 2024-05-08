package hr.fer.zavrsni1500.itshop.model;

import lombok.Getter;

@Getter
public enum UsedState {
    USED("Rabljeno"),
    NEW("Novo");

    private final String usedState;

    UsedState(String usedState) {
        this.usedState = usedState;
    }

}
