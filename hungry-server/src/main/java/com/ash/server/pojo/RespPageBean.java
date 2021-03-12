package com.ash.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description TODO
 * @Author ash
 * @Date 2021/3/11 21:13
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespPageBean {

    private Long total;//总条数

    private List<?>data;//数据list
}
