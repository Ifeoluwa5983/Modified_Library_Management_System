package com.library.libraryManagementSystem.web.controllers.library;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.libraryManagementSystem.data.model.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class LibraryRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    ObjectMapper mapper;
    Library library;

    @BeforeEach
    void setUp() {
        mapper = new ObjectMapper();
        library = new Library();
    }

    @Test
    void testCreateLibraryEndpoint_thenReturnOK() throws Exception {
        library.setName("The end");

        this.mockMvc.perform(post("/library/createLibrary")
                .contentType("application/json")
                .content(mapper.writeValueAsString(library)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    void testGetAllLibrariesEndpoint() throws Exception {
        this.mockMvc.perform(get("/library/allLibraries"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void testGetLibraryByIdEndpoint() throws Exception {
        this.mockMvc.perform(get("/library/findLibraryById/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void testDeleteLibraryByIdEndpoint() throws Exception {
        this.mockMvc.perform(delete("/library/deleteLibraryById/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void testUpdateLibraryEndpoint() throws Exception {
        library.setId(1);
        library.setName("Ife's library");

        this.mockMvc.perform(patch("/library/updateLibrary")
                .contentType("application/json")
                .content(mapper.writeValueAsString(library)))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

}