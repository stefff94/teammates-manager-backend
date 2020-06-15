package it.polste.attsw.teammatesmanagerbackend.repositories;

import it.polste.attsw.teammatesmanagerbackend.models.Skill;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SkillRepository {

    private static final String TEMPORARY_IMPLEMENTATION = "Temporary Implementation";

    public List<Skill> findAll(){
        throw new UnsupportedOperationException(TEMPORARY_IMPLEMENTATION);
    }

    public Optional<Skill> findById(long id){
        throw new UnsupportedOperationException(TEMPORARY_IMPLEMENTATION);
    }

    public Skill save(Skill skill){
        throw new UnsupportedOperationException(TEMPORARY_IMPLEMENTATION);
    }
}
