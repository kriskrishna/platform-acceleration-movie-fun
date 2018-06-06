package org.superbiz.moviefun.plays;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.val;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.IOException;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by kshitizkriskrishna on 8/9/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = PlayServiceApplication.class)
public class PlayControllerTest {

    @Autowired
    private PlaysRepository playsRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAddPlay() throws Exception, JsonMappingException, IOException {

        val play = new TestPlayBuilder().build();

        String playString = new ObjectMapper().writeValueAsString(play);

        mockMvc.perform(post("/plays")
                .contentType(MediaType.APPLICATION_JSON)
                .content(playString))
                .andReturn().getResponse().getContentAsString();
    }


    @Test
    public void testGetPlays() throws Exception, JsonMappingException, IOException {


        MvcResult result = mockMvc.perform(get("/plays"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(1)))
                .andReturn();
                //.andExpect(content().string("{JSON_DATA}"));
                //.andExpect(jsonPath("$", hasSize(20)));
        String content = result.getResponse().getContentAsString();

        System.out.println("############");

        System.out.println(content);

    }
}
