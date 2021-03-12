package com.ash.server.converter;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @Description 日期转换
 * @Author ash
 * @Date 2021/3/11 21:17
 * @Version 1.0
 **/
@Component
public class DateConverter implements Converter<String,LocalDate> {

    @Override
    public LocalDate convert(String source) {
        try{
            return LocalDate.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
