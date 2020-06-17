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

import java.util.Arrays;

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

  @Before
  public void setup() {
    RestAssuredMockMvc.standaloneSetup(teammateRestController);
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
    PersonalData stefanosData = new PersonalData("Stefano Vannucchi",
            "stefano.vannucchi@stud.unifi.it",
            "M",
            "Prato",
            "student",
            "https://semantic-ui.com/images/avatar/large/steve.jpg");

    PersonalData paolosData = new PersonalData("Paolo Innocenti",
            "paolo.innocenti@stud.unifi.it",
            "M",
            "Pistoia",
            "student",
            "https://semantic-ui.com/images/avatar/large/elliot.jpg");

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

}
