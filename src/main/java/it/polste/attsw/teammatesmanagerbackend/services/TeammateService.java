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
}
