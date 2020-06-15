package it.polste.attsw.teammatesmanagerbackend.services;

import it.polste.attsw.teammatesmanagerbackend.repositories.SkillRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(MockitoJUnitRunner.class)
public class SkillServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(SkillServiceTest.class);

    @Mock
    private SkillRepository skillRepository;

    @InjectMocks
    private SkillService skillService;

    @Test
    public void getAllSkillsTest(){

    }
}
