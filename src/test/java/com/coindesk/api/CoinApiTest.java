package com.coindesk.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CoinApiTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void findAll() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/coins");
        MvcResult result = mvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().is(200))
                .andReturn();
        String body = result.getResponse().getContentAsString();
        System.out.println(body);
    }

    @Test
    public void findByCode() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/coin/{code}", "USD");
        MvcResult result = mvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().is(200))
                .andReturn();
        String body = result.getResponse().getContentAsString();
        System.out.println(body);
    }

    @Test
    public void create() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/coin")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\"code\":\"TWD\",\n" +
                        "\"name\":\"台幣\",\n" +
                        "\"symbol\":\"&#36\",\n" +
                        "\"rate\":\"32,237.50\",\n" +
                        "\"description\":\"New Taiwan Dollar\",\n" +
                        "\"rateFloat\":32237.50\n" +
                        "}");
        MvcResult result = mvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().is(201))
                .andReturn();
        String body = result.getResponse().getContentAsString();
        System.out.println(body);
    }

    @Test
    public void update() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/coin/{code}", "USD")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\"code\":\"TWD\",\n" +
                        "\"name\":\"台幣\",\n" +
                        "\"symbol\":\"&#36\",\n" +
                        "\"rate\":\"32,237.50\",\n" +
                        "\"description\":\"New Taiwan Dollar\",\n" +
                        "\"rateFloat\":32237.50\n" +
                        "}");
        MvcResult result = mvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String body = result.getResponse().getContentAsString();
        System.out.println(body);
    }

    @Test
    public void delete() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .delete("/coin/{code}", "USD");
        mvc.perform(request)
                .andExpect(status().is(204))
                .andDo(print());
    }
}