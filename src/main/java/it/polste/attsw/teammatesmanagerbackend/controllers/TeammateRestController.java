package it.polste.attsw.teammatesmanagerbackend.controllers;

import it.polste.attsw.teammatesmanagerbackend.models.Teammate;
import it.polste.attsw.teammatesmanagerbackend.services.TeammateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/teammates")
public class TeammateRestController {

  private TeammateService teammateService;

  @Autowired
  public TeammateRestController(TeammateService teammateService) {
    this.teammateService = teammateService;
  }

  @GetMapping
  public List<Teammate> allTeammates() {
    return teammateService.getAllTeammates();
  }

}
