package it.polste.attsw.teammatesmanagerbackend.services;

import it.polste.attsw.teammatesmanagerbackend.models.PersonalData;
import it.polste.attsw.teammatesmanagerbackend.models.Teammate;
import it.polste.attsw.teammatesmanagerbackend.repositories.TeammateRepository;

import java.util.List;
import static java.util.Arrays.asList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;
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

    @InjectMocks
    private TeammateService teammateService;

    private PersonalData personalData1;
    private PersonalData personalData2;

    @Before
    public void setup(){
        personalData1 = new PersonalData("name1", "mail1", "male", "city1",
                "role1", "photoUrl1");
        personalData2 = new PersonalData("name2", "mail2", "female", "city2",
                "role2", "photoUrl2");
    }

    @Test
    public void getAllTeammatesTest(){
        Teammate teammate1 = new Teammate(1L, personalData1);
        Teammate teammate2 = new Teammate(2L, personalData2);

        when(teammateRepository.findAll())
                .thenReturn(asList(teammate1, teammate2));
        List<Teammate> result = teammateService.getAllTeammates();

        assertThat(result).containsExactly(teammate1, teammate2);

    }
}
