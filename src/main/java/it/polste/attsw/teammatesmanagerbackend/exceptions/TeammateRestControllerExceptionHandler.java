package it.polste.attsw.teammatesmanagerbackend.exceptions;

import it.polste.attsw.teammatesmanagerbackend.controllers.TeammateRestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice(assignableTypes = TeammateRestController.class)
public class TeammateRestControllerExceptionHandler extends ResponseEntityExceptionHandler {

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(TeammateNotExistsException.class)
  public ResponseEntity<Object> handleTeammateNotFoundException(
          TeammateNotExistsException e, WebRequest webRequest) {

    Map<String, String> body = new HashMap<>();
    body.put("message", e.getMessage());

    return handleExceptionInternal(e, body, new HttpHeaders(),
            HttpStatus.INTERNAL_SERVER_ERROR, webRequest);
  }
}
