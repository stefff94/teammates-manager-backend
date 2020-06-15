package it.polste.attsw.teammatesmanagerbackend;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/bdd/resources",
        glue = {"it.polste.attsw.teammatesmanagerbackend.steps"},
        monochrome = true,
        strict = true)
public class HealthCheckBDD { }
