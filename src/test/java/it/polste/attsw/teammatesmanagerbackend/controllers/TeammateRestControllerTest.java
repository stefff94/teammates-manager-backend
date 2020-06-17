package it.polste.attsw.teammatesmanagerbackend.controllers;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import it.polste.attsw.teammatesmanagerbackend.models.PersonalData;
import it.polste.attsw.teammatesmanagerbackend.models.Teammate;
import it.polste.attsw.teammatesmanagerbackend.services.TeammateService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;

import java.util.Arrays;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.when;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.empty;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TeammateRestControllerTest {

  @Mock
  private TeammateService teammateService;

  @InjectMocks
  private TeammateRestController teammateRestController;

  private PersonalData stefanosData;
  private PersonalData paolosData;

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
                    new Teammate(1L, stefanosData),
                    new Teammate(2L, paolosData)
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
                    )
            );
  }

  @Test
  public void testInsertNewTeammateWithSuccess() {
    Teammate teammateToInsert = new Teammate(null, stefanosData);

    when(teammateService.insertNewTeammate(teammateToInsert))
            .thenReturn(new Teammate(null, stefanosData));

    given().
            contentType(MediaType.APPLICATION_JSON_VALUE).
            body(teammateToInsert).
    when().
            post("/api/teammates/new").
    then().
            statusCode(200).
            assertThat().
            body(
                    "id", hasItem(1),
                    "personalData.name", hasItem("Stefano Vannucchi"),
                    "personalData.email", hasItem("stefano.vannucchi@stud.unifi.it"),
                    "personalData.gender", hasItem("M"),
                    "personalData.city", hasItem("Prato"),
                    "personalData.role", hasItem("student"),
                    "personalData.photoUrl", hasItem(
                            "https://semantic-ui.com/images/avatar/large/steve.jpg")
            );
  }

}
