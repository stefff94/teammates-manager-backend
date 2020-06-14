package it.polste.attsw.teammatesmanagerbackend.services;

import it.polste.attsw.teammatesmanagerbackend.models.Skill;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

  private static final String TEMPORARY_IMPLEMENTATION = "Temporary implementation";

  public List<Skill> getAllSkills() {
    throw new UnsupportedOperationException(TEMPORARY_IMPLEMENTATION);
  }
}
