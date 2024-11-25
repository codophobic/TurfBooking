package org.example.models;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Turf extends BaseEntity{
    private List<Slot> slots;
    private Owner owner;
    private static int cnt = 0;
    public Turf(Owner owner) {
        super(cnt++);
        this.slots = createSlots();
        this.owner = owner;
    }

    public List<Slot> createSlots() {
        List<Slot> slots = new ArrayList<>();
        for(int i=10;i<=20;i=i+2){
            slots.add(new Slot(i,i+2));
        }
        return slots;
    }
}
