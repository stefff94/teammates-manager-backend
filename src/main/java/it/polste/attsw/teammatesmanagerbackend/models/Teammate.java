package it.polste.attsw.teammatesmanagerbackend.models;

public class Teammate {

  private Long id;

  private PersonalData personalData;

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
}
