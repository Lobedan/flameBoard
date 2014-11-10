package de.flameboard.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Sven on 07.11.2014.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
@ImportResource(value = "/META-INF/thymeleaf.xml")
public class FlameBoard extends SpringBootServletInitializer {

  //CHECKSTYLE:OFF
  public static void main(String[] args) throws Exception {
    SpringApplication.run(FlameBoard.class, args);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(FlameBoard.class);
  }
  //CHECKSTYLE:ON
}

