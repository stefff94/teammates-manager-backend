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
        return setTeammateData(null, teammate);
    }

    private Teammate setTeammateData(Long id, Teammate teammate){
        teammate.setId(id);

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
        String mail = teammate.getPersonalData().getEmail();
        if(mailExists(mail)){
            throw new IllegalArgumentException("This mail has already been associated with a Teammate");
        }

        Optional<Teammate> existingTeammate = teammateRepository.findById(id);
        if(existingTeammate.isPresent()){
            return setTeammateData(id, teammate);
        }else{
            throw new IllegalArgumentException("No Teammate with id " + id + " exists!");
        }
    }

    private boolean mailExists(String mail) {
        Optional<Teammate> existingMail = teammateRepository.findByMail(mail);
        return existingMail.isPresent();
    }

    public void deleteTeammate(Long id){
        Optional<Teammate> teammate = teammateRepository.findById(id);

        if(teammate.isPresent()){
            teammateRepository.deleteById(id);
        }else{
            String message = "No Teammate with id " + id + " exists!";
            throw new IllegalArgumentException(message);
        }

    }
}
