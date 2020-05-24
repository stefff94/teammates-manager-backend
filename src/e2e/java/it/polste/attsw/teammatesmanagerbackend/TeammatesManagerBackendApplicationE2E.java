package it.polste.attsw.teammatesmanagerbackend;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.when;

public class TeammatesManagerBackendApplicationE2E {

  private static final Logger logger =
          LoggerFactory.getLogger(TeammatesManagerBackendApplicationE2E.class);

  private static int port =
          Integer.parseInt(System.getProperty("server.port", "8080"));

  private static String baseUrl;

  @Before
  public void setup() {
    baseUrl = "http://localhost:" + port;
  }

  @Test
  public void proofTest() {
    when().
            get(baseUrl + "/actuator/health").
    then().
            statusCode(200);
  }

}
