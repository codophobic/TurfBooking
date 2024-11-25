package org.example.repository;

import org.example.models.Turf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TurfRepository {
    private List<Turf> turfStore;

    public TurfRepository() {
        this.turfStore = new ArrayList<>();
    }

    public void addTurf(Turf turf){
        turfStore.add(turf);
    }

    public List<Turf> getAllTurfs(){
        return turfStore;
    }
}
