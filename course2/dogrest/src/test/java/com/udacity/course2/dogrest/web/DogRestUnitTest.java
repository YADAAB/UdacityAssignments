package com.udacity.course2.dogrest.web;


import com.udacity.course2.dogrest.service.DogQueryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockMvcClientHttpRequestFactory;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.util.HashMap;

import static org.mockito.Mockito.verify;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static sun.awt.util.PerformanceLogger.times;
import static org.mockito.internal.verification.VerificationModeFactory.times;


@RunWith(SpringRunner.class)
@WebMvcTest(value = DogController.class,excludeAutoConfiguration = {SecurityAutoConfiguration.class})
//@AutoConfigureMockMvc
public class DogRestUnitTest {
    @Autowired
    private MockMvc mockMvc;
    private ResultActions rs;

    @MockBean
    DogQueryService dogQueryService;

    @Test
    public void getDogBreed() throws Exception {
        mockMvc.perform(get("/dogs/").with(user("admin").password("password").roles("USER","ADMIN"))) //sessionAttrs(sessionattr))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));
        verify(dogQueryService, times(1)).getDogBreed();
    }



    @Test
    public void getDogNames() throws Exception {
        MvcResult res = mockMvc.perform(get("/dogs/names/").with(user("admin").password("password").roles("USER","ADMIN"))) //sessionAttrs(sessionattr))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                //.andExpect(content().json("[]"))
                .andReturn()
                ;
        String content = res.getResponse().getContentAsString();
        System.out.println("content - "+content);
        verify(dogQueryService, times(1)).getDogNames();
    }

}
//APPLICATION_JSON_UTF8

//getDogBreed