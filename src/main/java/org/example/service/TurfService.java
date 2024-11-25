package org.example.service;

import org.example.models.Owner;
import org.example.models.Playground;
import org.example.models.Turf;
import org.example.repository.PlaygroundRepository;
import org.example.repository.TurfRepository;
import org.example.repository.UserRepository;

public class TurfService {

    private TurfRepository turfRepository;
    private UserRepository userRepository;
    private PlaygroundRepository playgroundRepository;

    public TurfService(TurfRepository turfRepository, UserRepository userRepository, PlaygroundRepository playgroundRepository) {
        this.turfRepository = turfRepository;
        this.userRepository = userRepository;
        this.playgroundRepository = playgroundRepository;
    }

    public Turf createTurf(Owner owner, Playground playground) {
        Turf turf = new Turf(owner);
        turfRepository.addTurf(turf);

        Owner user = (Owner) userRepository.getUser(owner.getId());
        user.getOwnedTurfs().add(turf);

        Playground playground1 = playgroundRepository.getPlayground();
        playground1.getTurfs().add(turf);

        return turf;
    }
}
