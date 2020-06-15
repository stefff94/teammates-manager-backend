package it.polste.attsw.teammatesmanagerbackend.services;

import it.polste.attsw.teammatesmanagerbackend.models.Skill;
import it.polste.attsw.teammatesmanagerbackend.models.Teammate;
import it.polste.attsw.teammatesmanagerbackend.repositories.TeammateRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TeammateService {

    private final TeammateRepository teammateRepository;
    private final SkillService skillService;

    public TeammateService(TeammateRepository teammateRepository, SkillService skillService){
        this.teammateRepository = teammateRepository;
        this.skillService = skillService;
    }

    public List<Teammate> getAllTeammates(){
        return teammateRepository.findAll();
    }

    public Teammate insertNewTeammate(Teammate teammate){
        teammate.setId(null);

        Set<Skill> teammateSkills = new HashSet<>();
        teammate.getSkills().forEach(skill ->
                teammateSkills.add(skillService.insertNewSkill(skill)));
        teammate.setSkills(teammateSkills);

        return teammateRepository.save(teammate);
    }

    public void deleteTeammate(Long id){
        teammateRepository.findById(id)
                .ifPresent(teammate -> teammateRepository.deleteById(id));
    }
}
