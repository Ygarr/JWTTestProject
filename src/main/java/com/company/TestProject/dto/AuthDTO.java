package com.company.TestProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Data Transfer Object or DTO is a (anti) pattern introduced with EJB.
 * Instead of performing many remote calls on EJBs,
 * the idea was to encapsulate data in a value object that could be transfered over the network:
 * a Data Transfer Object.
 *
 */
@Data
@AllArgsConstructor
public class AuthDTO
{
    private String userName;
    private String passWord;

    private String userLastname;
    private Integer userId;

}
