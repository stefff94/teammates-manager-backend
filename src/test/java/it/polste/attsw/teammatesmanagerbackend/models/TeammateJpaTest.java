package it.polste.attsw.teammatesmanagerbackend.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
public class TeammateJpaTest {

  private static final Logger logger =
          LoggerFactory.getLogger(TeammateJpaTest.class);

  @Autowired
  private TestEntityManager entityManager;

  @Test
  public void testJpaMapping() {
    PersonalData personalData = new PersonalData("Stefano Vannucchi",
            "stefano.vannucchi@stud.unifi.it",
            "M",
            "Prato",
            "student",
            "https://semantic-ui.com/images/avatar/large/steve.jpg");

    Set<Skill> skills = new HashSet<>();
    skills.add(new Skill(1L, "Java"));
    skills.add(new Skill(2L, "Vue js"));

    Teammate teammate =
            entityManager.persistFlushFind(new Teammate(null, personalData, skills));

    assertThat(teammate.getPersonalData()).isEqualTo(personalData);
    assertThat(teammate.getSkills())
            .containsExactlyInAnyOrderElementsOf(skills);
    assertThat(teammate.getId()).isNotNull();
    assertThat(teammate.getId()).isGreaterThan(0);

    logger.info("Persisted entity with id:" + teammate.getId());
  }

}
