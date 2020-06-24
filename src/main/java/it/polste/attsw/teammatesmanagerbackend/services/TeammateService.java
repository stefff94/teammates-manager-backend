package it.polste.attsw.teammatesmanagerbackend.services;

import it.polste.attsw.teammatesmanagerbackend.models.Teammate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeammateService {

  public static final String TEMPORARY_IMPLEMENTATION = "Temporary implementation";

  public List<Teammate> getAllTeammates() {
    throw new UnsupportedOperationException(TEMPORARY_IMPLEMENTATION);
  }

  public Teammate insertNewTeammate(Teammate teammate) {
    throw new UnsupportedOperationException(TEMPORARY_IMPLEMENTATION);
  }

  public Teammate updateTeammate(Long id, Teammate teammate) {
    throw new UnsupportedOperationException(TEMPORARY_IMPLEMENTATION);
  }

  public void deleteTeammate(Long id) {
    throw new UnsupportedOperationException(TEMPORARY_IMPLEMENTATION);
  }

}
