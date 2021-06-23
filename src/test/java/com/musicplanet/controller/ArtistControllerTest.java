package com.musicplanet.controller;

import com.fasterxml.jackson.core.type.TypeReference;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
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
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        ArtistDTO artist = new ArtistDTO();
        artist.setId(1L);
        artist.setName("Testartist");

        mvc.perform(post("/artists/")
                .contentType("application/json")
                .content(ow.writeValueAsString(artist)))
                .andExpect(status().isOk());


    }

    @WithMockUser(value = "spring")
    @Test
    void getAll() throws Exception {
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
    void getByName() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/artists/name/artistname"))
                .andExpect(status().isOk());
    }

    @WithMockUser(value = "spring")
    @Test
    void update() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        ArtistDTO artist = new ArtistDTO();
        artist.setId(1L);
        artist.setName("Testartist");

        mvc.perform(post("/artists/")
                .contentType("application/json")
                .content(ow.writeValueAsString(artist)))
                .andExpect(status().isOk());

        ObjectWriter ow2 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        ArtistDTO artist2 = new ArtistDTO();
        artist2.setId(1L);
        artist2.setName("Testartist2");

        mvc.perform(MockMvcRequestBuilders.put("/artists/1")
                .contentType("application/json")
                .content(ow.writeValueAsString(artist2)))
                .andExpect(status().is(404));

    }

    @WithMockUser(value = "spring")
    @Test
    void delete() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        ArtistDTO artist = new ArtistDTO();
        artist.setId(1L);
        artist.setName("Testartist");

        mvc.perform(post("/artists/")
                .contentType("application/json")
                .content(ow.writeValueAsString(artist)))
                .andExpect(status().isOk());

        mvc.perform(MockMvcRequestBuilders.delete("/artists/1"))
                .andExpect(status().isOk());
    }

    @WithMockUser(value = "spring")
    @Test
    void deleteAll() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/artists/"))
                .andExpect(status().is(204));
    }
}