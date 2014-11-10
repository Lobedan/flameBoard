package de.flameboard.board.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by Sven on 08.11.2014.
 * <p>
 * passes configuration classes to thymeleaf
 */
@ControllerAdvice
public class ConfigurationAdvice implements EnvironmentAware {

  private Environment env;
  @Autowired
  private FlameBoardConfiguration config;

  @ModelAttribute(value = "environment")
  public Environment getEnvConfig() {
    return env;
  }

  @ModelAttribute(value = "configuration")
  public FlameBoardConfiguration getConfig() { return config; }

  @Override
  @Autowired
  public void setEnvironment(Environment environment) {
    env = environment;
  }
}
