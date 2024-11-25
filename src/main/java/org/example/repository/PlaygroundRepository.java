package org.example.repository;

import org.example.models.Playground;

import java.util.ArrayList;
import java.util.List;

public class PlaygroundRepository {
    private List<Playground> playgroundList;


    public PlaygroundRepository() {
        this.playgroundList = new ArrayList<>();
    }

    public void addPlayground(Playground playground){
        playgroundList.add(playground);
    }

    public Playground getPlayground(){
        return playgroundList.get(0);
    }
}
