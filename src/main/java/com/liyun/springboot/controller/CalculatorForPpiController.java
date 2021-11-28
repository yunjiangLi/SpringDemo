//控制层实现
package com.liyun.springboot.controller;

import com.liyun.springboot.service.CalculatorForPpiService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/v2")
public class CalculatorForPpiController {

@Resource
    private CalculatorForPpiService calculatorForPpiService;

//    public CalculatorForPpiController(CalculatorForPpiService calculatorForPpiService) {
//        this.calculatorForPpiService = calculatorForPpiService;
//    }

    @PostMapping(value = "/calculate")  //   /v2/calculate为接口名
    public String calculate(@RequestParam("width") int width,@RequestParam("height") int height,@RequestParam("size") double size){
        long result = calculatorForPpiService.calculate(width, height, size);
        return "{\"PPI\":"+result+"}";//json格式字符串
    }
}
