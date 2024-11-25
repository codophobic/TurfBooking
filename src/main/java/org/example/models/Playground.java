package org.example.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Playground extends BaseEntity {

    private List<Turf> turfs;
    private static int cnt =0;
    public Playground(){
        super(cnt++);
        this.turfs = new ArrayList<>();
    }
}
