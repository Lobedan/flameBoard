package de.flameboard.board.theme;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;

import de.flameboard.board.annotation.Builder;
import de.flameboard.board.aware.CleanAware;
import de.flameboard.board.configuration.FlameBoardConfiguration;

/**
 * Created by Sven on 08.11.2014.
 */
@Builder
public class TemplateViewBuilder implements CleanAware {
  private static final Logger LOGGER = Logger.getLogger(TemplateViewBuilder.class);

  @Autowired
  private FlameBoardConfiguration config;

  @Autowired
  private final ResourceLoader resourceLoader = new DefaultResourceLoader();

  private String theme = null;
  private String htmlPath = null;
  private String templateName = null;

  public TemplateViewBuilder() {
  }

  public String getTheme() {
    return (theme == null) ? config.getTheme() : theme;
  }

  public TemplateViewBuilder setTheme(String aTheme) {
    theme = aTheme;
    return this;
  }

  public String getHtmlPath() {
    return (htmlPath == null) ? config.getHtmlPath() : htmlPath;
  }

  public TemplateViewBuilder setHtmlPath(String aHtmlPath) {
    htmlPath = aHtmlPath;
    return this;
  }

  public String getTemplateName() {
    return templateName;
  }

  public TemplateViewBuilder setTemplateName(String aTemplateName) {
    templateName = aTemplateName;
    return this;
  }

  public String build() {
    StringBuilder sb = new StringBuilder();
    sb.append(getTheme()).append("/");
    sb.append(getHtmlPath()).append("/");
    if (templateName == null) {
      throw new InvalidTemplateException("TemplateName may not be null");
    } else if (!templateExists(templateName)) {
      LOGGER.error("Template "
                   + templateName
                   + " in path "
                   + config.getTplPath()
                   + getTheme()
                   + "/"
                   + getHtmlPath()
                   + " does not exist, using default template in "
                   + config.getTheme());
      if (theme != null) {
        sb = new StringBuilder();
        sb.append(config.getTheme()).append("/");
        sb.append(config.getHtmlPath()).append("/");
      }
      sb.append(templateName);
    } else {
      sb.append(templateName);
    }
    clear();
    return sb.toString();
  }

  private boolean templateExists(String name) {
    return this.resourceLoader
        .getResource(config.getTplPath() + getTheme() + "/" + getHtmlPath() + "/" + name + ".html").exists();
  }

  /**
   * this function clears all class fields, because spring does autowire it and will leave the old values
   */
  @Override
  public void clear() {
    this.setTheme(null).setHtmlPath(null).setTemplateName(null);
  }
}
