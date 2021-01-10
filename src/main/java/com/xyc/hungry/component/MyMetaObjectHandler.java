package com.xyc.hungry.component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @program: hungry
 * @description:
 * @author: ash
 * @create: 2021/01/10 17:32
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("userUpdateTime",LocalDateTime.now(),metaObject);
        this.setFieldValByName("userCreateTime",LocalDateTime.now(),metaObject);
        this.setFieldValByName("userLoginTime",LocalDateTime.now(),metaObject);
        this.setFieldValByName("userDelete", 0, metaObject);
        this.setFieldValByName("userState", 0, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("userUpdateTime",LocalDateTime.now(),metaObject);
        this.setFieldValByName("userLoginTime",LocalDateTime.now(),metaObject);
    }
}
