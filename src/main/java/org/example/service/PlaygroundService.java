package org.example.service;

import org.example.enums.SlotStatus;
import org.example.models.Playground;
import org.example.models.Slot;
import org.example.models.Turf;
import org.example.models.TurfSlot;
import org.example.repository.PlaygroundRepository;

import java.util.ArrayList;
import java.util.List;

public class PlaygroundService {
    private PlaygroundRepository playgroundRepository;

    public PlaygroundService(PlaygroundRepository playgroundRepository) {
        this.playgroundRepository = playgroundRepository;
    }

    public Playground createPlaground(){
        Playground playground = new Playground();
        playgroundRepository.addPlayground(playground);
        return playground;
    }

    public List<TurfSlot> getAvailableSlots(){
        Playground playground = playgroundRepository.getPlayground();
        List<Turf> turfs = playground.getTurfs();
        List<TurfSlot> availableSlots = new ArrayList<>();
        for(Turf turf : turfs){
            for(Slot slot: turf.getSlots()){
                if(SlotStatus.AVAILABLE.equals(slot.getSlotStatus())){
                    availableSlots.add(new TurfSlot(turf,slot));
                }
            }
        }
        return availableSlots;
    }
}
