package de.flameboard.board.controller.acp;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.flameboard.board.configuration.FlameBoardConfiguration;
import de.flameboard.board.theme.TemplateViewBuilder;

/**
 * Created by Sven on 08.11.2014.
 */
@Controller
@RequestMapping(value = "/acp")
public class AcpMainController {
  private static final Logger LOGGER = Logger.getLogger(AcpMainController.class);

  @Autowired
  private TemplateViewBuilder templateBuilder;

  @Autowired
  private FlameBoardConfiguration config;

  @RequestMapping(value = { "", "/index", "/home", "/start" }, method = RequestMethod.GET)
  public String home() {
    return templateBuilder
        .setTheme(config.getAcp())
        .setHtmlPath("html")
        .setTemplateName("index")
        .build();
  }

  @RequestMapping(value = "/config", method = RequestMethod.GET)
  public String config() {
    return templateBuilder
        .setTheme(config.getAcp())
        .setHtmlPath("html")
        .setTemplateName("config")
        .build();
  }

  @RequestMapping(value = "/test", method = RequestMethod.GET)
  public String testTwo() {
    return templateBuilder
        .setTheme("main")
        .setTemplateName("index")
        .build();
  }
}
