package com.company.TestProject.services;

import com.company.TestProject.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService
{
    private static Map<String, User> users = new HashMap<String, User>();

    static {
        users.put(
                "user1", User
                            .builder()
                            .userId(0)
                            .userName("user1")
                            .userLastname(null)
                            .passWord("123") // Never do this!
                            .email("user1@romania.com")
                            .role(User.ROLE_ADMIN)
                            .isActivated(true)
                            .build()
        );
    }

    static {
        users.put(
                "test", User
                        .builder()
                        .userId(1)
                        .userName("testName")
                        .userLastname("testLastname")
                        .passWord("correct") // Never do this!
                        .email("info@titan-technologies.org")
                        .role(User.ROLE_USER)
                        .isActivated(true)
                        .build()
        );
    }

    public User findUserByUserName(String userName)
    {
        return users.get(userName);
    }


    public User findUserByUserId(Integer userId)
    {
        return users.get(userId);
    }

    public Boolean authenticate(String userName, String passWord)
    {
        User user = findUserByUserName(userName);

        if (null!=user) {
            return user.getPassWord().equals(passWord);
        }

        return false;
    }

    public Boolean authenticate(String userName, String passWord, String userLastame, Integer Id)
    {
        User user = findUserByUserName(userName);

        if (null!=user) {
            return user.getPassWord().equals(passWord);
        }

        return false;
    }
}
