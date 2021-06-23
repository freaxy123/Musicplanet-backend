package com.musicplanet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.musicplanet.dto.ArtistDTO;
import com.musicplanet.dto.PlaylistDTO;
import com.musicplanet.services.ArtistService;
import com.musicplanet.services.PlaylistService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
class PlaylistControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PlaylistService playlistService;

    @WithMockUser(value = "spring")
    @Test
    void getAll() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/playlists/"))
                .andExpect(status().isOk());
    }

    @WithMockUser(value = "spring")
    @Test
    void get() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/playlists/1"))
                .andExpect(status().is(404));
    }

    @WithMockUser(value = "spring")
    @Test
    void getByName() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/playlists/name/artistname"))
                .andExpect(status().isOk());
    }

    @WithMockUser(value = "spring")
    @Test
    void add() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        PlaylistDTO playlist = new PlaylistDTO();
        playlist.setId(1L);
        playlist.setName("Testartist");
        /*
      mvc.perform(post("/playlists/")
                .contentType("application/json")
                .content(ow.writeValueAsString(playlist)))
                .andExpect(status().isOk());

         */


    }

    @WithMockUser(value = "spring")
    @Test
    void update() {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        PlaylistDTO playlist = new PlaylistDTO();
        playlist.setId(1L);
        playlist.setName("testplaylist");
/*
        mvc.perform(post("/playlists/")
                .contentType("application/json")
                .content(ow.writeValueAsString(playlist)))
                .andExpect(status().isOk());

 */

        ObjectWriter ow2 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        PlaylistDTO playlist2 = new PlaylistDTO();
        playlist2.setId(1L);
        playlist2.setName("Testartist2");

        /*
        mvc.perform(MockMvcRequestBuilders.put("/artists/1")
                .contentType("application/json")
                .content(ow.writeValueAsString(playlist2)))
                .andExpect(status().is(404));

         */
    }

    @WithMockUser(value = "spring")
    @Test
    void delete() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        PlaylistDTO playlist = new PlaylistDTO();
        playlist.setId(1L);
        playlist.setName("Testartist");

        /*
        mvc.perform(post("/playlists/")
                .contentType("application/json")
                .content(ow.writeValueAsString(playlist)))
                .andExpect(status().isOk());
*/
        mvc.perform(MockMvcRequestBuilders.delete("/playlists/1"))
                .andExpect(status().isOk());
    }

    @WithMockUser(value = "spring")
    @Test
    void deleteAll() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/playlists/"))
                .andExpect(status().is(204));
    }
}