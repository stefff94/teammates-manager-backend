package it.polste.attsw.teammatesmanagerbackend.controllers;

import it.polste.attsw.teammatesmanagerbackend.models.Skill;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class SkillRestController {

  @GetMapping("/api/skills")
  public List<Skill> allSkills() {
    return Collections.emptyList();
  }
}
