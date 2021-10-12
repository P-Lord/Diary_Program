package com.plord.diary.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author admin
 * @since 2021-10-10
 */
@Data
    public class User implements Serializable {

    private String id;

    private String username;

    private String email;

    private String password;

    private String location;

    private Date firstday;

    private int sex;


}
