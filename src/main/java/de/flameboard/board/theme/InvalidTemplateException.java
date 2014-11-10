package de.flameboard.board.theme;

import org.apache.log4j.Logger;

/**
 * Created by Sven on 08.11.2014.
 */
public class InvalidTemplateException extends RuntimeException {
  private static final Logger LOGGER = Logger.getLogger(InvalidTemplateException.class);

  public InvalidTemplateException() {
  }

  public InvalidTemplateException(String message) {
    super(message);
  }

  public InvalidTemplateException(String message, Throwable cause) {
    super(message, cause);
  }

  public InvalidTemplateException(Throwable cause) {
    super(cause);
  }

  public InvalidTemplateException(String message,
                                  Throwable cause,
                                  boolean enableSuppression,
                                  boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
