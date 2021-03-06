package it.polste.attsw.teammatesmanagerbackend.repositories;

import it.polste.attsw.teammatesmanagerbackend.models.Teammate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeammateRepository extends JpaRepository<Teammate, Long> {
  Optional<Teammate> findByPersonalDataEmail(String email);
}
