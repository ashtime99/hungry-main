package com.ash.server.common.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum ResultEnum {

    SUCCESS(200, "成功"),
    UPDATE_SUCCESS(200, "更新成功"),
    DELETE_SUCCESS(200, "删除成功"),
    UPDATE_ERR(400, "更新失败"),
    DELETE_ERR(400, "删除失败"),
    ;
    public Integer code;
    public String message;

}
