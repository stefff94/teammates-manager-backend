package it.polste.attsw.teammatesmanagerbackend.repositories;

import it.polste.attsw.teammatesmanagerbackend.models.Teammate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeammateRepository {

    private static final String TEMPORARY_IMPLEMENTATION = "Temporary Implementation";

    public List<Teammate> findAll(){
        throw new UnsupportedOperationException(TEMPORARY_IMPLEMENTATION);
    }
}
