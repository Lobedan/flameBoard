package de.flameboard.board.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Sven on 08.11.2014.
 */
@Configuration
@ConfigurationProperties(
    locations = "classpath:flameboard.properties",
    prefix = "flameboard",
    ignoreNestedProperties = true,
    exceptionIfInvalid = false,
    ignoreUnknownFields = false
)
@PropertySource(value = "classpath:flameboard.properties", ignoreResourceNotFound = true)
public class FlameBoardConfiguration {

  @Value("${flameboard.application.name}")
  private String applicationName;

  @Value("${flameboard.application.url.api}")
  private String apiUrl;

  @Value("${flameboard.application.url.resource}")
  private String resourceServerUrl;

  @Value("${flameboard.environment}")
  private String environment = "development";

  @Value("${flameboard.theme}")
  private String theme = "main";

  @Value("${flameboard.storage.attachment}")
  private String attachmentStorage;

  @Value("${flameboard.storage.avatar}")
  private String avatarStorage;

  @Value("${flameboard.storage.smilies}")
  private String smiliesStorage;

  @Value("${flameboard.path.css}")
  private String cssPath = "css";

  @Value("${flameboard.path.html}")
  private String htmlPath = "html";

  @Value("${flameboard.path.js}")
  private String jsPath = "js";

  @Value("${flameboard.path.tpl}")
  private String tplPath = "classpath:/templates/";

  @Value("${flameboard.path.acp}")
  private String acp = "acp";

  @Value("${flameboard.path.assets}")
  private String assetsPath;

  public String getApiUrl() {
    return apiUrl;
  }

  public void setApiUrl(String aApiUrl) {
    apiUrl = aApiUrl;
  }

  public String getResourceServerUrl() {
    return resourceServerUrl;
  }

  public void setResourceServerUrl(String aResourceServerUrl) {
    resourceServerUrl = aResourceServerUrl;
  }

  public String getAttachmentStorage() {
    return attachmentStorage;
  }

  public void setAttachmentStorage(String aAttachmentStorage) {
    attachmentStorage = aAttachmentStorage;
  }

  public String getAvatarStorage() {
    return avatarStorage;
  }

  public void setAvatarStorage(String aAvatarStorage) {
    avatarStorage = aAvatarStorage;
  }

  public String getSmiliesStorage() {
    return smiliesStorage;
  }

  public void setSmiliesStorage(String aSmiliesStorage) {
    smiliesStorage = aSmiliesStorage;
  }

  public String getAssetsPath() {
    return assetsPath;
  }

  public void setAssetsPath(String aAssetsPath) {
    assetsPath = aAssetsPath;
  }

  public String getApplicationName() {
    return applicationName;
  }

  public void setApplicationName(String aApplicationName) {
    applicationName = aApplicationName;
  }

  public String getAcp() {
    return acp;
  }

  public void setAcp(String aAcp) {
    acp = aAcp;
  }

  public String getEnvironment() {
    return environment;
  }

  public void setEnvironment(String aEnvironment) {
    environment = aEnvironment;
  }

  public String getTheme() {
    return theme;
  }

  public void setTheme(String aTheme) {
    theme = aTheme;
  }

  public String getCssPath() {
    return cssPath;
  }

  public void setCssPath(String aCssPath) {
    cssPath = aCssPath;
  }

  public String getHtmlPath() {
    return htmlPath;
  }

  public void setHtmlPath(String aHtmlPath) {
    htmlPath = aHtmlPath;
  }

  public String getJsPath() {
    return jsPath;
  }

  public void setJsPath(String aJsPath) {
    jsPath = aJsPath;
  }

  public String getTplPath() {
    return tplPath;
  }

  public void setTplPath(String aTplPath) {
    tplPath = aTplPath;
  }
}
