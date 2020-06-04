package it.polste.attsw.teammatesmanagerbackend.repositories;

import it.polste.attsw.teammatesmanagerbackend.models.Skill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
public class SkillRepositoryTest {

  private static final Logger logger =
          LoggerFactory.getLogger(SkillRepositoryTest.class);

  @Autowired
  private SkillRepository skillRepository;

  @Autowired
  private TestEntityManager testEntityManager;

  @Test
  public void saveAndReadRecordWithRepositoryTest() {
    Skill skill = new Skill(null, "Spring Boot");
    Skill persistedSkill = skillRepository.save(skill);
    List<Skill> skills = skillRepository.findAll();
    assertThat(skills).containsExactly(persistedSkill);

    logger.info("Persisted and retrieved entity with id: "
            + skills.get(0).getId());
  }

  @Test
  public void saveWithTestEntityManagerAndReadWithRepositoryTest() {
    Skill skill = new Skill(null, "Spring Boot");
    Skill persistedSkill = testEntityManager.persistFlushFind(skill);
    List<Skill> skills = skillRepository.findAll();
    assertThat(skills).containsExactly(persistedSkill);

    logger.info("Persisted and retrieved entity with id: "
            + skills.get(0).getId());
  }

}
