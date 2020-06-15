package it.polste.attsw.teammatesmanagerbackend.models;

public class Skill {

  private Long id;

  private String name;

  public Skill() {}

  public Skill(long id, String skillName) {
    this.id = id;
    this.name = skillName;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
