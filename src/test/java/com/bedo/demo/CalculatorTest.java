package com.bedo.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CalculatorTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CalculatorController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void squareShouldReturnDefaultValue() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/square", Integer.class)).isEqualTo(4);
    }

    @Test
    public void squareShouldReturnSquareValue() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/square?x=-1", Integer.class))
                .isEqualTo(1);
    }
}
