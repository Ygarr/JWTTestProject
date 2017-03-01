package com.company.TestProject.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User
{
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_USER = "USER";

    private Integer userId;
    private String userName;
    private String userLastname;
    private String passWord;
    private String email;
    private String description;
    private String role;
    private Boolean isActivated;
    private Boolean isAdmin;
}
