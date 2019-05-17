package com.springboot.helloworld;

import com.springboot.helloworld.controller.HelloWorldController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloworldApplicationTests {

    private MockMvc mvc;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
    }

    @Test
    public void testHelloWorld() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/hello").);

        /**
         *  1.  mockMvc.request 执行请求
         *  2.  MockMvcRequestBuilders.get  创建请求
         *  3.  MockMvcRequestBuilders.accept 设置返回类型及编码
         *  4.  ResultActions.param 添加请求参数
         *  5.  ResultActions.andExpect 添加断言
         *  6.  ResultActions.andDo 添加结果处理器
         */
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
