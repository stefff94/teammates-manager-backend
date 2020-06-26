package it.polste.attsw.teammatesmanagerbackend.repositories;

import it.polste.attsw.teammatesmanagerbackend.models.Teammate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TeammateRepository {

    private static final String TEMPORARY_IMPLEMENTATION = "Temporary Implementation";

    public List<Teammate> findAll(){ throw new UnsupportedOperationException(TEMPORARY_IMPLEMENTATION); }

    public Optional<Teammate> findById(Long id){ throw new UnsupportedOperationException(TEMPORARY_IMPLEMENTATION); }

    public Optional<Teammate> findByPersonalDataEmail(String mail){ throw new UnsupportedOperationException(TEMPORARY_IMPLEMENTATION); }

    public Teammate save(Teammate teammate){ throw new UnsupportedOperationException(TEMPORARY_IMPLEMENTATION); }

    public void deleteById(Long id){ throw new UnsupportedOperationException(TEMPORARY_IMPLEMENTATION); }

}
