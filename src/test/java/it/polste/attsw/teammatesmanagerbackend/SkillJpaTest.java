package it.polste.attsw.teammatesmanagerbackend;

import it.polste.attsw.teammatesmanagerbackend.models.Skill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


@DataJpaTest
@RunWith(SpringRunner.class)
public class SkillJpaTest {

  @Autowired
  private TestEntityManager entityManager;

  @Test
  public void testJpaMapping() {
    Skill skill =
            entityManager.persistFlushFind(new Skill(null, "Spring Boot"));
  }

}
