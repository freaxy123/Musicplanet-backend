package com.musicplanet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.musicplanet.dto.ArtistDTO;
import com.musicplanet.entities.Artist;
import com.musicplanet.services.ArtistService;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
class ArtistControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ArtistService artistService;

    @WithMockUser(value = "spring")
    @Test
    void add() throws Exception {
        ArtistDTO artist = new ArtistDTO();
        artist.setId(1L);
        artist.setName("Testartist");

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(artist);

        mvc.perform(post("/artists/")
                .contentType("application/json")
                .content(json))
                .andExpect(status().isOk());
    }

    @WithMockUser(value = "spring")
    @Test
    void getAll() throws Exception {
        /*
        RequestBuilder request = MockMvcRequestBuilders.get("/artists");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("", result.getResponse().getContentAsString());

         */

        mvc.perform(MockMvcRequestBuilders.get("/artists/"))
                .andExpect(status().isOk());
    }

    @WithMockUser(value = "spring")
    @Test
    void get() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/artists/1"))
                .andExpect(status().isOk());
    }

    @WithMockUser(value = "spring")
    @Test
    void getByName() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteAll() {
    }
}