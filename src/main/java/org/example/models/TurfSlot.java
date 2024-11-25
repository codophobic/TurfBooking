package org.example.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TurfSlot {
    private Turf turf;
    private Slot slot;

    public TurfSlot(Turf turf, Slot slot) {
        this.turf = turf;
        this.slot = slot;
    }
}
