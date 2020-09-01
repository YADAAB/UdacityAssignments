package com.udacity.course2.dogrest.web;

import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

public class DogRestIntegTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getDogNames() {
        String plainCreds = "admin:password";
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        String base64Creds = new String(base64CredsBytes);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Creds);

        HttpEntity<String> request = new HttpEntity<String>(headers);
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:" + port + "/dogs/names/", HttpMethod.GET, request, String.class);
        System.out.println("response status - "+response.getStatusCode());
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    /*
    @RestController
public class ConsumeWebService {
   @Autowired
   RestTemplate restTemplate;

   @RequestMapping(value = "/template/products")
   public String getProductList() {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity <String> entity = new HttpEntity<String>(headers);

      return restTemplate.exchange("
         http://localhost:8080/products", HttpMethod.GET, entity, String.class).getBody();
   }
}
    * */


    /*@Test
    public void getLocation() {
        ResponseEntity<Location> response =
                this.restTemplate.getForEntity("http://localhost:" + port + "/location/1", Location.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }*/
}
