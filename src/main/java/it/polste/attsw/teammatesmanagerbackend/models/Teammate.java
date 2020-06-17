package it.polste.attsw.teammatesmanagerbackend.models;

import java.util.Set;

public class Teammate {

  private Long id;

  private PersonalData personalData;

  private Set<Skill> skills;

  public Teammate() {}

  public Teammate(Long id, PersonalData personalData, Set<Skill> skills) {
    this.id = id;
    this.personalData = personalData;
    this.skills = skills;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public PersonalData getPersonalData() {
    return personalData;
  }

  public void setPersonalData(PersonalData personalData) {
    this.personalData = personalData;
  }

  public Set<Skill> getSkills() {
    return skills;
  }

  public void setSkills(Set<Skill> skills) {
    this.skills = skills;
  }
}
