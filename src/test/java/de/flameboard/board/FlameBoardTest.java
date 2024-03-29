package de.flameboard.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sven on 07.11.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FlameBoard.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
@DirtiesContext
public class FlameBoardTest {

  @Value("${local.server.port}")
  private int port;

  @Test
  public void integrationTest() throws Exception {
    ResponseEntity<String> entity = new TestRestTemplate()
        .getForEntity("http://localhost:" + this.port + "/health", String.class);
    assertEquals(HttpStatus.OK, entity.getStatusCode());
  }
}
