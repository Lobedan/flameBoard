package de.flameboard.board.theme;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.flameboard.board.FlameBoard;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Sven on 08.11.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = FlameBoard.class)
public class TemplateViewBuilderTest {
  private static final Logger LOGGER = Logger.getLogger(TemplateViewBuilderTest.class);

  @Autowired
  private TemplateViewBuilder builder;

  @Test
  public void testCanBuildRightTemplateName() throws Exception {
    assertThat(builder.setTheme("main").setTemplateName("index").build(), is("main/html/index"));
    assertThat(builder.setTheme("main").setHtmlPath("html2").setTemplateName("index").build(), is("main/html/index"));

    assertThat(builder.setTheme("test").setTemplateName("index").build(), is("main/html/index"));
    assertThat(builder.setTheme("test").setHtmlPath("html2").setTemplateName("index").build(), is("main/html/index"));

    assertThat(builder.setTheme("test2").setTemplateName("index").build(), is("test2/html/index"));
    assertThat(builder.setTheme("test2").setHtmlPath("html").setTemplateName("index").build(), is("test2/html/index"));
    assertThat(builder.setTheme("test2").setHtmlPath("html2").setTemplateName("index").build(), is("main/html/index"));
  }
}
