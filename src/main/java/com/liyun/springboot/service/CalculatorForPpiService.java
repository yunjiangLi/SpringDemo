package com.liyun.springboot.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorForPpiService {
    public long calculate(int width,int height,double size){
        long result;
        if(width > 0 && height >0 && size > 0){
            result = Math.round(Math.pow((Math.pow(width,2) + Math.pow(height,2)) /Math.pow(size,2), 0.5));
        }
        else{
            result = -1;
        }
        return  result;
    }
}
