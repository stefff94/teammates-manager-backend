package it.polste.attsw.teammatesmanagerbackend.services;

import it.polste.attsw.teammatesmanagerbackend.models.PersonalData;
import it.polste.attsw.teammatesmanagerbackend.models.Skill;
import it.polste.attsw.teammatesmanagerbackend.models.Teammate;
import it.polste.attsw.teammatesmanagerbackend.repositories.TeammateRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import static java.util.Arrays.asList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class TeammateServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(TeammateServiceTest.class);

    @Mock
    private TeammateRepository teammateRepository;

    @Mock
    private SkillService skillService;

    @InjectMocks
    private TeammateService teammateService;

    private PersonalData personalData1;
    private PersonalData personalData2;
    private Set<Skill> skills1;
    private Set<Skill> skills2;
    private Skill savedSkill;
    private Skill skillToSave;

    @Before
    public void setup(){
        personalData1 = new PersonalData("name1", "mail1", "male", "city1",
                "role1", "photoUrl1");
        personalData2 = new PersonalData("name2", "mail2", "female", "city2",
                "role2", "photoUrl2");

        skills1 = new HashSet<>();
        savedSkill = new Skill(1L, "skill");
        skills1.add(savedSkill);

        skills2 = new HashSet<>();
        skillToSave = new Skill(999L, "skill");
        skills2.add(skillToSave);
    }

    @Test
    public void getAllTeammatesTest(){
        Teammate teammate1 = new Teammate(1L, personalData1, skills1);
        Teammate teammate2 = new Teammate(2L, personalData2, skills2);

        when(teammateRepository.findAll())
                .thenReturn(asList(teammate1, teammate2));
        List<Teammate> result = teammateService.getAllTeammates();

        assertThat(result).containsExactly(teammate1, teammate2);
        logger.info("Recovered " + result.size() + " teammates");
    }

    @Test
    public void insertNewTeammateReturnsSavedTeammateWithIdTest(){
        Teammate saved = new Teammate(1L, personalData1, skills1);
        Teammate toSave = spy(new Teammate(999L, personalData2, skills2));

        when(skillService.insertNewSkill(any(Skill.class)))
                .thenReturn(savedSkill);
        when(teammateRepository.save(any(Teammate.class)))
                .thenReturn(saved);

        Teammate result = teammateService.insertNewTeammate(toSave);

        assertThat(result).isSameAs(saved);
        assertThat(toSave.getSkills()).isEqualTo(skills1);
        verify(skillService, times(1)).insertNewSkill(skillToSave);

        logger.info("Inserted new teammate with id: " + saved.getId());

        InOrder inOrder = inOrder(toSave, skillService, teammateRepository);
        inOrder.verify(toSave).setId(null);
        inOrder.verify(skillService).insertNewSkill(skillToSave);
        inOrder.verify(teammateRepository).save(toSave);
    }

    @Test
    public void deleteTeammateTest(){
        Teammate teammate = new Teammate(1L, personalData1, skills1);

        when(teammateRepository.findById(1L)).thenReturn(Optional.of(teammate));
        teammateService.deleteTeammate(1L);

        verify(teammateRepository, times(1)).deleteById(1L);
        logger.info("Deleted teammate with id: " + teammate.getId());
    }

    @Test
    public void updateTeammateByIdReturnsUpdatedTeammateWithPreviousIdTest(){
        Teammate replacement = spy(new Teammate(null, personalData1, skills2));
        Teammate replaced = new Teammate(1L, personalData1, skills1);

        when(skillService.insertNewSkill(any(Skill.class)))
                .thenReturn(savedSkill);
        when(teammateRepository.save(any(Teammate.class)))
                .thenReturn(replaced);

        Teammate result = teammateService.updateTeammate(1L, replacement);

        assertThat(result).isSameAs(replaced);
        assertThat(replacement.getSkills()).isEqualTo(skills1);
        verify(skillService, times(1)).insertNewSkill(skillToSave);

        InOrder inOrder = inOrder(replacement, teammateRepository);
        inOrder.verify(replacement).setId(1L);
        inOrder.verify(teammateRepository).save(replacement);
        logger.info("Updated teammate with id: " + replaced.getId());
    }
}
