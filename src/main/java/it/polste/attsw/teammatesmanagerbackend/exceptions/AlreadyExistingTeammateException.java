package it.polste.attsw.teammatesmanagerbackend.exceptions;

public class AlreadyExistingTeammateException extends RuntimeException {

  public AlreadyExistingTeammateException(String message) {
    super(message);
  }
}
