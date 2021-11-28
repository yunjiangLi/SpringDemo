package com.liyun.springboot.service;

import com.liyun.springboot.Application;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@SpringBootTest(classes = {Application.class})
public class CalcculateForPpiServiceTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private CalculatorForPpiService service;
    private int width;
    private int height;
    private double size;

    @BeforeClass
    public void init(){
        width = 750;
        height = 1334;
        size = 4.7;
    }

    @Test
    public void testCase1(){
        long result = service.calculate(width,height,size);
        Assert.assertEquals( 326,result);
    }
    @Test
    public void testCase2(){
        Assert.assertEquals(-1,service.calculate(-1,height,size));
    }
    @Test
    public void testCase3(){
        Assert.assertEquals(-1,service.calculate(0,height,size));
    }
    @Test
    public void testCase4(){
        Assert.assertEquals(-1,service.calculate(width,-1,size));
    }

    @Test
    public void testCase5(){
        Assert.assertEquals(-1,service.calculate(width,0,size));
    }
    @Test
    public void testCase6(){
        Assert.assertEquals(-1,service.calculate(width,height,-1));
    }
    @Test
    public void testCase7(){
        Assert.assertEquals(-1,service.calculate(width,height,0));
    }
}
