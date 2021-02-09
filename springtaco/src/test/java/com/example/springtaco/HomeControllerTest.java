package com.example.springtaco;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest() //针对homeController进行的web测试
public class HomeControllerTest {
    @Autowired
    private MockMvc mockMvc;  //注入MockMVC
    @Test
    public void testHomePage() throws Exception {
        //mockMvc.perform(get("/")).andExpect((ResultMatcher) status().isOk()).andExpect(view().name("home")).andExpect(content().string(containsString("Welcome to ....")));
    }


}
