package it.polste.attsw.teammatesmanagerbackend;

import it.polste.attsw.teammatesmanagerbackend.models.PersonalData;
import it.polste.attsw.teammatesmanagerbackend.models.Teammate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
public class TeammateJpaTest {

  private static final Logger logger = LoggerFactory.getLogger(TeammateJpaTest.class);

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

    Teammate teammate = entityManager.persistFlushFind(new Teammate(null, personalData));
  }

}
