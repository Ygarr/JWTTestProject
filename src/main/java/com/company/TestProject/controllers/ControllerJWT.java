package com.company.TestProject.controllers;

import com.company.TestProject.model.JwtUser;
import com.company.TestProject.services.JwtService;
import com.company.TestProject.services.UserService;
import com.company.TestProject.dto.AuthDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Rest service... controller with security calls
 */
@RestController
public class ControllerJWT
{

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @GetMapping(value = "/api/secure/hello/{name}")
    public ResponseEntity<?> helloSecure(@PathVariable String name)
    {
        String result = String.format("Hello JWT, %s! (Secure)", name);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/api/public/hello/{name}")
    public ResponseEntity<?> helloPublic(@PathVariable String name)
    {
        String result = String.format("Hello JWT, %s! (Public)", name);
        return ResponseEntity.ok(result);
    }

    @PostMapping(value = "/api/public/auth")
    public ResponseEntity<?> auth(@RequestBody AuthDTO auth) {
        String userName = auth.getUserName();
        String passWord = auth.getPassWord();
        //String userLastname = auth.getLastname();
        Integer userId = auth.getUserId();
        Boolean correctCredentials = userService.authenticate(userName, passWord);
        if (correctCredentials) {
            JwtUser jwtUser = new JwtUser(userName, passWord, null, userId);
            return ResponseEntity.ok(jwtService.getToken(jwtUser));
        }
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }


    @PostMapping(value = "/TestProject/auth")
    public ResponseEntity<?> getJWT(@RequestBody AuthDTO auth) {
        String userName = auth.getUserName();
        String passWord = auth.getPassWord();

        String userLastname = auth.getUserLastname();
        Integer userId = auth.getUserId();

        Boolean correctCredentials = userService.authenticate(userName, passWord);

        if (correctCredentials) {
            JwtUser jwtUser = new JwtUser(userName, passWord, userLastname, userId);
            String result = String.format("token:",  jwtService.getToken(jwtUser));
            return ResponseEntity.ok(result);
        }

        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }



    @GetMapping(value = "/TestProject/user/{id}")
    public ResponseEntity<?> helloSecure(@PathVariable Integer id)   {

        String result = String.format("firstName: ", userService.findUserByUserId(id));
        return ResponseEntity.ok(result);
    }


}
