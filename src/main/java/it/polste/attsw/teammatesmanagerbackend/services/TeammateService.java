package it.polste.attsw.teammatesmanagerbackend.services;

import it.polste.attsw.teammatesmanagerbackend.models.Teammate;
import it.polste.attsw.teammatesmanagerbackend.repositories.TeammateRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeammateService {

    private final TeammateRepository teammateRepository;

    public TeammateService(TeammateRepository teammateRepository){
        this.teammateRepository = teammateRepository;
    }

    public List<Teammate> getAllTeammates(){
        List<Teammate> result = new ArrayList<>();
        return result;
    }
}
