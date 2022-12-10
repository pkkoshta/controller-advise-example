package com.prashant.service;

import com.prashant.dto.UserDTO;
import com.prashant.exception.InvalidInputException;
import com.prashant.exception.UserNotFoundException;
import com.prashant.model.User;
import com.prashant.repository.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
@Autowired
    private UserDao userDao;

    @Override
    public List<UserDTO> getUsers() {
        List<User> usersList = userDao.findAll();
        return mapToDTO(usersList);

    }

    @Override
    public UserDTO createUser(User user) {
        User userResponse = null;
        UserDTO dto = null;
        if (user != null){
            userResponse= userDao.save(user);

            dto= new UserDTO(userResponse.getId(), userResponse.getName(), user.getLastname(),
                    user.getPassword(), userResponse.getAge(),
                    userResponse.getSex(), userResponse.getEmail());
            return dto;

        }

        else
          throw new UserNotFoundException( );
    }

    @Override
    public void deleteUser(int uid) {
//        if (uid != 0 )
//            userDao.deleteById(uid);
//        else
            throw new InvalidInputException("User id invalid...");
    }

    @Override
    public User findbyId(int uid) {
        return null;
    }


    private static List<UserDTO> mapToDTO(List<User> user){
       List<UserDTO> dto = null;

       dto = user.stream().map(u-> new UserDTO(u.getId(), u.getName(),
               u.getLastname(), u.getPassword(),
               u.getAge(), u.getSex(), u.getEmail())).collect(Collectors.toList());
        return dto;
    }
}
