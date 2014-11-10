package de.flameboard.board.configuration;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.flameboard.board.FlameBoard;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Sven on 08.11.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = FlameBoard.class)
public class ConfigurationAdviceTest {
  private static final Logger LOGGER = Logger.getLogger(ConfigurationAdviceTest.class);
  @Autowired
  private ConfigurationAdvice advice;

  @Autowired
  private FlameBoardConfiguration configuration;

  @Test
  public void testCanGetConfiguration() throws Exception {
    assertThat(advice.getConfig(), is(notNullValue()));
    assertThat(advice.getConfig().getEnvironment(), is(configuration.getEnvironment()));
  }
}
