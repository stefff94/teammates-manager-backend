package it.polste.attsw.teammatesmanagerbackend.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.when;


public class HealthCheckSteps {

  private static final Logger logger =
          LoggerFactory.getLogger(HealthCheckSteps.class);

  private static int port =
          Integer.parseInt(System.getProperty("server.port", "8080"));
  private static String baseUrl;

  private Response response;

  @Before
  public void setup() {
    baseUrl = "http://localhost:" + port;
  }

  @Given("I perform a GET request to the health check url")
  public void i_perform_a_get_request_to_the_health_check_url() {
    logger.info(baseUrl + "/actuator/health");
    response = when().get(baseUrl + "/actuator/health");
  }

  @Then("The application response with a {int} status code")
  public void the_application_response_with_a_status_code(int statusCode) {
    response.then().statusCode(statusCode);
  }

}
