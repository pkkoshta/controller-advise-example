package com.prashant.controller;

import com.prashant.dto.UserDTO;
import com.prashant.model.User;
import com.prashant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void deleteUserById(@PathVariable int id){
        userService.deleteUser(id);
    }
    @PostMapping(produces = "application/json")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        User user = null;
        UserDTO dto = null;

        if (userDTO != null){
            user = new User();
            user.setName(userDTO.getName());
            user.setLastname(userDTO.getLastname());
            user.setAge(userDTO.getAge());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            user.setSex(userDTO.getSex());
            dto = userService.createUser(user);
        }
        return new ResponseEntity<>(dto, HttpStatus.CREATED);

    }

    @GetMapping
    public List<UserDTO> users(){
        return userService.getUsers();
    }
}
