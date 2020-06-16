package it.polste.attsw.teammatesmanagerbackend.controllers;

import it.polste.attsw.teammatesmanagerbackend.models.Teammate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class TeammateRestController {

  @GetMapping("/api/teammates")
  public List<Teammate> allTeammates() {
    return Collections.emptyList();
  }
}
