package com.library.libraryManagementSystem.web.controllers.book;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.libraryManagementSystem.data.model.Book;
import com.library.libraryManagementSystem.data.model.IsAvailable;
import com.library.libraryManagementSystem.data.model.Library;
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
class BookRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper mapper;
    Book book;

    @BeforeEach
    void setUp() {
        mapper = new ObjectMapper();
        book = new Book();
    }

    @Test
    void testCreateBookEndpoint_thenReturnOK() throws Exception {
        book.setTitle("Rapture");
        book.setIsAvailable(IsAvailable.FALSE);
        book.setAuthor("Chima");

        this.mockMvc.perform(post("/book/create")
                .contentType("application/json")
                .content(mapper.writeValueAsString(book)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    void testGetAllBooksEndpoint() throws Exception {
        this.mockMvc.perform(get("/book/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void testGetBookByIdEndpoint() throws Exception {
        this.mockMvc.perform(get("/book/one/4"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void testDeleteBookByIdEndpoint() throws Exception {
        this.mockMvc.perform(delete("/book/one/4"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void testUpdateBookEndpoint() throws Exception {
        book.setId(5);
        book.setAuthor("Iclass");

        this.mockMvc.perform(patch("/book/update")
                .contentType("application/json")
                .content(mapper.writeValueAsString(book)))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }


}