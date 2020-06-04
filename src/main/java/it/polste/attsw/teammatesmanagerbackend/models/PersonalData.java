package it.polste.attsw.teammatesmanagerbackend.models;

import javax.persistence.Embeddable;

@Embeddable
public class PersonalData {

  private String name;

  private String email;

  private String gender;

  private String city;

  private String role;

  private String photoUrl;

  public PersonalData() {}

  public PersonalData(String name, String email, String gender, String city, String role, String photoUrl) {
    this.name = name;
    this.email = email;
    this.gender = gender;
    this.city = city;
    this.role = role;
    this.photoUrl = photoUrl;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getPhotoUrl() {
    return photoUrl;
  }

  public void setPhotoUrl(String photoUrl) {
    this.photoUrl = photoUrl;
  }
}
