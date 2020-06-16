package it.polste.attsw.teammatesmanagerbackend.controllers;

import it.polste.attsw.teammatesmanagerbackend.models.PersonalData;
import it.polste.attsw.teammatesmanagerbackend.models.Teammate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = TeammateRestController.class)
public class TeammateRestControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private TeammateService teammateService;

  @Test
  public void testGetAllTeammatesWhenEmpty() throws Exception {
    this.mockMvc.perform(get("/api/teammates")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().json("[]"));
  }

  public void testGetAllTeammatesWhenNotEmpty() throws Exception {
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

    this.mockMvc.perform(get("/api/teammates"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id", is(1)))
            .andExpect(jsonPath("$[0].personalData.name", is("Stefano Vannucchi")))
            .andExpect(jsonPath("$[0].personalData.email",
                            is("stefano.vannucchi@stud.unifi.it")))
            .andExpect(jsonPath("$[0].personalData.gender", is("M")))
            .andExpect(jsonPath("$[0].personalData.city", is("Prato")))
            .andExpect(jsonPath("$[0].personalData.role", is("student")))
            .andExpect(jsonPath("$[0].personalData.photoUrl",
                    is("https://semantic-ui.com/images/avatar/large/steve.jpg")))
            .andExpect(jsonPath("$[1].id", is(2)))
            .andExpect(jsonPath("$[1].personalData.email",
                    is("paolo.innocenti@stud.unifi.it")))
            .andExpect(jsonPath("$[1].personalData.gender", is("M")))
            .andExpect(jsonPath("$[1].personalData.city", is("Pistoia")))
            .andExpect(jsonPath("$[1].personalData.role", is("student")))
            .andExpect(jsonPath("$[1].personalData.photoUrl",
                    is("https://semantic-ui.com/images/avatar/large/elliot.jpg")));
  }

}
