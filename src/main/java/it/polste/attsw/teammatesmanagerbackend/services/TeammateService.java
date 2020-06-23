package it.polste.attsw.teammatesmanagerbackend.services;

import it.polste.attsw.teammatesmanagerbackend.models.Skill;
import it.polste.attsw.teammatesmanagerbackend.models.Teammate;
import it.polste.attsw.teammatesmanagerbackend.repositories.TeammateRepository;
import org.springframework.dao.EmptyResultDataAccessException;
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

        Set<Skill> savedSkills = saveSkillsForTeammate(teammate.getSkills());
        teammate.setSkills(savedSkills);

        return teammateRepository.save(teammate);
    }

    private Set<Skill> saveSkillsForTeammate(Set<Skill> skills){
        Set<Skill> teammateSkills = new HashSet<>();
        skills.forEach(skill ->
                teammateSkills.add(skillService.insertNewSkill(skill)));
        return teammateSkills;
    }

    public Teammate updateTeammate(Long id, Teammate teammate){
        teammate.setId(id);

        Set<Skill> savedSkills = saveSkillsForTeammate(teammate.getSkills());
        teammate.setSkills(savedSkills);

        return teammateRepository.save(teammate);
    }

    public void deleteTeammate(Long id) {
        try{
            teammateRepository.deleteById(id);
        }catch(EmptyResultDataAccessException e){
            String message = "No Teammate with id " + id + " exists!";
            throw new IllegalArgumentException(message);
        }
    }
}
