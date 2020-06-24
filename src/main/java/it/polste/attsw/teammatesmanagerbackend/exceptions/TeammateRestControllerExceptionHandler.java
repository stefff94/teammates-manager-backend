package it.polste.attsw.teammatesmanagerbackend.exceptions;

import it.polste.attsw.teammatesmanagerbackend.controllers.TeammateRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice(assignableTypes = TeammateRestController.class)
public class TeammateRestControllerExceptionHandler extends ResponseEntityExceptionHandler {

  public static final String TEMPORARY_IMPLEMENTATION = "Temporary implementation";

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler({TeammateNotExistsException.class,
          AlreadyExistingTeammateException.class})
  public ResponseEntity<Object> handleTeammateException(
          Exception e, WebRequest webRequest) {

    throw new UnsupportedOperationException(TEMPORARY_IMPLEMENTATION);
  }
}
