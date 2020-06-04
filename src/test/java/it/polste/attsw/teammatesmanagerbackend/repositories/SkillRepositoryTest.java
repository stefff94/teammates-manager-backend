package it.polste.attsw.teammatesmanagerbackend.repositories;

import it.polste.attsw.teammatesmanagerbackend.models.Skill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
public class SkillRepositoryTest {

  @Autowired
  private SkillRepository skillRepository;

  @Test
  public void saveAndReadRecordWithRepository() {
    Skill skill = new Skill(null, "Spring Boot");
    Skill persistedSkill = skillRepository.save(skill);
    List<Skill> skills = skill.findAll();
    assertThat(skills).containsExactly(persistedSkill);
  }

}
