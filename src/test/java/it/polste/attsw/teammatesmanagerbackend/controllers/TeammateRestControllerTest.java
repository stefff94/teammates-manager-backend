package it.polste.attsw.teammatesmanagerbackend.controllers;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import it.polste.attsw.teammatesmanagerbackend.models.PersonalData;
import it.polste.attsw.teammatesmanagerbackend.models.Skill;
import it.polste.attsw.teammatesmanagerbackend.models.Teammate;
import it.polste.attsw.teammatesmanagerbackend.services.TeammateService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.when;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.empty;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TeammateRestControllerTest {

  @Mock
  private TeammateService teammateService;

  @InjectMocks
  private TeammateRestController teammateRestController;

  private PersonalData stefanosData;
  private PersonalData paolosData;
  private Set<Skill> skills;

  @Before
  public void setup() {
    RestAssuredMockMvc.standaloneSetup(teammateRestController);

    stefanosData = new PersonalData("Stefano Vannucchi",
            "stefano.vannucchi@stud.unifi.it",
            "M",
            "Prato",
            "student",
            "https://semantic-ui.com/images/avatar/large/steve.jpg");

    paolosData = new PersonalData("Paolo Innocenti",
            "paolo.innocenti@stud.unifi.it",
            "M",
            "Pistoia",
            "student",
            "https://semantic-ui.com/images/avatar/large/elliot.jpg");

    skills = new HashSet<>();
    skills.add(new Skill(1L, "Spring Boot"));
    skills.add(new Skill(2L, "Vue js"));
  }

  @Test
  public void testGetAllTeammatesWhenEmpty() {
    when().
            get("/api/teammates").
    then().
            statusCode(200).
            assertThat().
            body("", empty());
  }

  @Test
  public void testGetAllTeammatesWhenNotEmpty() {
    when(teammateService.getAllTeammates())
            .thenReturn(Arrays.asList(
                    new Teammate(1L, stefanosData, skills),
                    new Teammate(2L, paolosData, skills)
            ));

    when().
            get("/api/teammates").
    then().
            statusCode(200).
            assertThat().
            body(
                    "id", hasItems(1, 2),
                    "personalData.name", hasItems("Stefano Vannucchi", "Paolo Innocenti"),
                    "personalData.email", hasItems(
                            "stefano.vannucchi@stud.unifi.it",
                            "paolo.innocenti@stud.unifi.it"
                    ),
                    "personalData.gender", hasItem("M"),
                    "personalData.city", hasItems("Prato", "Pistoia"),
                    "personalData.role", hasItem("student"),
                    "personalData.photoUrl", hasItems(
                            "https://semantic-ui.com/images/avatar/large/steve.jpg",
                            "https://semantic-ui.com/images/avatar/large/elliot.jpg"
                    ),
                    "skills.id", everyItem(hasItems(1, 2)),
                    "skills.name", everyItem(hasItems("Spring Boot", "Vue js"))
            );
  }

  @Test
  public void testInsertNewTeammateWithSuccess() {
    Teammate teammateToInsert = new Teammate(null, stefanosData, skills);

    when(teammateService.insertNewTeammate(ArgumentMatchers.any(Teammate.class)))
            .thenReturn(new Teammate(1L, stefanosData, skills));

    given().
            contentType(MediaType.APPLICATION_JSON_VALUE).
            body(teammateToInsert).
    when().
            post("/api/teammates/new").
    then().
            statusCode(200).
            assertThat().
            body(
                    "id", equalTo(1),
                    "personalData.name", equalTo("Stefano Vannucchi"),
                    "personalData.email", equalTo("stefano.vannucchi@stud.unifi.it"),
                    "personalData.gender", equalTo("M"),
                    "personalData.city", equalTo("Prato"),
                    "personalData.role", equalTo("student"),
                    "personalData.photoUrl", equalTo(
                            "https://semantic-ui.com/images/avatar/large/steve.jpg"),
                    "skills.id", hasItems(1, 2),
                    "skills.name", hasItems("Spring Boot", "Vue js")
            );
  }

  @Test
  public void testUpdateNewTeammateWithSuccess() {
    Teammate teammateToUpdate = new Teammate(null, stefanosData, skills);

    when(teammateService.updateTeammate(anyLong(), ArgumentMatchers.any(Teammate.class)))
            .thenReturn(new Teammate(1L, stefanosData, skills));

    given().
            contentType(MediaType.APPLICATION_JSON_VALUE).
            body(teammateToUpdate).
    when().
            put("/api/teammates/update/1").
    then().
            statusCode(200).
            assertThat().
            body(
                    "id", equalTo(1),
                    "personalData.name", equalTo("Stefano Vannucchi"),
                    "personalData.email", equalTo("stefano.vannucchi@stud.unifi.it"),
                    "personalData.gender", equalTo("M"),
                    "personalData.city", equalTo("Prato"),
                    "personalData.role", equalTo("student"),
                    "personalData.photoUrl", equalTo(
                            "https://semantic-ui.com/images/avatar/large/steve.jpg"),
                    "skills.id", hasItems(1, 2),
                    "skills.name", hasItems("Spring Boot", "Vue js")
            );
  }

  @Test
  public void testDeleteTeammateWithSuccess() {
    when().
            delete("api/teammates/delete/" + 1).
    then().
            statusCode(200);

    verify(teammateService, times(1)).deleteTeammate(1L);
  }

}
