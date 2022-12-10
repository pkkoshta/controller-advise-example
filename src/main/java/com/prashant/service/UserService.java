package com.prashant.service;

import com.prashant.dto.UserDTO;
import com.prashant.model.User;

import java.util.List;

public interface UserService {

    List<UserDTO> getUsers();

    UserDTO createUser(User user);

    void deleteUser(int uid);

    User findbyId(int uid);
}
