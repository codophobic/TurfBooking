package org.example.controllers;

import org.example.models.Owner;
import org.example.models.Playground;
import org.example.models.Turf;
import org.example.service.TurfService;

public class TurfsController {
    private TurfService turfService;


    public TurfsController(TurfService turfService) {
        this.turfService = turfService;
    }


    public Turf createNewTurf(Owner owner, Playground playground){
        return turfService.createTurf(owner,playground);
    }
}
