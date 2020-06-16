package it.polste.attsw.teammatesmanagerbackend.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

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
  private void testGetAllTeammatesWhenEmpty() throws Exception {
    this.mockMvc.perform(get("/api/teammates")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().json("[]"));
  }

}
