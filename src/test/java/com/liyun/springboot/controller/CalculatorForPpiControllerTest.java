package com.liyun.springboot.controller;

import com.liyun.springboot.Application;
import org.junit.Assert;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcResultMatchersDsl;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@SpringBootTest (classes = {Application.class})
public class CalculatorForPpiControllerTest {

    @Autowired
    private CalculatorForPpiController controller;

    private MockMvc mock;

    private RequestBuilder request;

    private String width;
    private String height;
    private String size;

    @BeforeClass
    public void init(){
        mock = MockMvcBuilders.standaloneSetup(controller).build();
        width = "750";
        height = "1334";
        size = "4.7";
    }

    @Test
    public void testCase1(){
        sendRequest(width,height,size,"326");
    }
    @Test
    public void testCase2(){
        sendRequest("-1",height,size,"-1");
    }
    @Test
    public void testCase3(){
        sendRequest("0",height,size,"-1");
    }
    @Test
    public void testCase4(){
        sendRequest(width,"-1",size,"-1");
    }
    @Test
    public void testCase5(){
        sendRequest(width,"0",size,"-1");
    }
    @Test
    public void testCase6(){
        sendRequest(width,height,"-1","-1");
    }
    @Test
    public void testCase7(){ sendRequest(width,height,"0","-1");
    }



    private void sendRequest(String width, String height, String size, String expected){
        request = MockMvcRequestBuilders.post("/v2/calculate").param("width", width).param("height",height).param("size",size);
        try{
            mock.perform(request).andExpect(MockMvcResultMatchers.jsonPath("PPI").value(expected));
        }catch (Exception e ){
            e.printStackTrace();
        }
    }
}
