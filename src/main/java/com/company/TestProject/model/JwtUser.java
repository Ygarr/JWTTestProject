package com.company.TestProject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtUser
{
    private String userName;
    private String role;

    private String userLastname;
    private Integer userId;
}
