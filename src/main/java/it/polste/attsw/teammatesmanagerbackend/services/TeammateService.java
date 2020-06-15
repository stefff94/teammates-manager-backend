package it.polste.attsw.teammatesmanagerbackend.services;

import it.polste.attsw.teammatesmanagerbackend.models.PersonalData;
import it.polste.attsw.teammatesmanagerbackend.models.Skill;
import it.polste.attsw.teammatesmanagerbackend.models.Teammate;
import it.polste.attsw.teammatesmanagerbackend.repositories.SkillRepository;
import it.polste.attsw.teammatesmanagerbackend.repositories.TeammateRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TeammateService {

    private final TeammateRepository teammateRepository;
    private final SkillRepository skillRepository;

    public TeammateService(TeammateRepository teammateRepository, SkillRepository skillRepository){
        this.teammateRepository = teammateRepository;
        this.skillRepository = skillRepository;
    }

    public List<Teammate> getAllTeammates(){
        return teammateRepository.findAll();
    }

    public Teammate insertNewTeammate(Teammate teammate){
        teammate.setId(null);
        return teammateRepository.save(teammate);
    }
}
