package it.polste.attsw.teammatesmanagerbackend.controllers;

import it.polste.attsw.teammatesmanagerbackend.models.Skill;
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
@WebMvcTest(controllers = SkillRestController.class)
public class SkillRestControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private SkillService skillService;

  @Test
  public void testGetAllSkillsWhenEmpty() throws Exception {
    this.mockMvc.perform(get("/api/skills")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().json("[]"));
  }

  public void testGetAllSkillsWhenNotEmpty() throws Exception {
    when(skillService.getAllSkills())
            .thenReturn(Arrays.asList(
                    new Skill(1L, "Spring Boot"),
                    new Skill(2L, "Vue js")
            ));

    this.mockMvc.perform(get("/api/skills")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id", is(1)))
            .andExpect(jsonPath("$[0].name", is("Spring Boot")))
            .andExpect(jsonPath("$[1].id", is(2)))
            .andExpect(jsonPath("$[1].name", is("Vue js")));
  }

}
