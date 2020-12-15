package com.library.libraryManagementSystem.web.controllers.readers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.libraryManagementSystem.data.model.Book;
import com.library.libraryManagementSystem.data.model.IsAvailable;
import com.library.libraryManagementSystem.data.model.Reader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ReaderRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    ObjectMapper mapper;
    Reader reader;

    @BeforeEach
    void setUp() {
        mapper = new ObjectMapper();
        reader = new Reader();
    }

    @Test
    void testCreateReaderEndpoint_thenReturnOK() throws Exception {

        reader.setLastName("iClass");
        reader.setFirstName("Chima");
        reader.setPhoneNumber("09087654321");
        reader.setEmail("test@gmail.com");

        this.mockMvc.perform(post("/reader/createReader")
                .contentType("application/json")
                .content(mapper.writeValueAsString(reader)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    void testGetAllReadersEndpoint() throws Exception {
        this.mockMvc.perform(get("/reader/allReaders"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void testGetReaderByIdEndpoint() throws Exception {
        this.mockMvc.perform(get("/reader/findReaderById/4"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void testDeleteReaderByIdEndpoint() throws Exception {
        this.mockMvc.perform(delete("/reader/deleteReaderById/4"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void testUpdateReaderEndpoint() throws Exception {
        reader.setId(2);
        reader.setFirstName("Dorcas");

        this.mockMvc.perform(patch("/reader/updateReader")
                .contentType("application/json")
                .content(mapper.writeValueAsString(reader)))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }



}