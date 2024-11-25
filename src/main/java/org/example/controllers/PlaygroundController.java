package org.example.controllers;

import org.example.models.Playground;
import org.example.models.Slot;
import org.example.models.TurfSlot;
import org.example.service.PlaygroundService;

import java.util.List;

public class PlaygroundController {
    private PlaygroundService playgroundService;

    public PlaygroundController(PlaygroundService playgroundService) {
        this.playgroundService = playgroundService;
    }

    public Playground createPlayground() {
        return playgroundService.createPlaground();
    }

    public List<TurfSlot> getAllAvailableSlots(Playground playground){
        return playgroundService.getAvailableSlots();
    }
}
