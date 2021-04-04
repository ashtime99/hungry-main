package com.ash.server.pojo;

import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author ash
 * @version 1.0
 * @since 2021/4/1 12:07
 */
@Data
public class LoginUser {
    private String username;
    private String password;
    private Object type;
}
