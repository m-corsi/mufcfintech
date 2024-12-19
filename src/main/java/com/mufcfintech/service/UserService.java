package com.mufcfintech.service;

import com.mufcfintech.api.UserApi;
import com.mufcfintech.dao.UserDAO;
import com.mufcfintech.entity.User;
import com.mufcfintech.mapper.UserMapper;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserDAO userDAO;

    //private final PasswordEncoder passwordEncoder;

    public UserService(
            //PasswordEncoder passwordEncoder,
                       UserDAO userDAO) {
        //this.passwordEncoder = passwordEncoder;
        this.userDAO = userDAO;
    }

    public UserApi createUser(UserApi userApi) {
        //userApi.setPassword(passwordEncoder.encode(userApi.getPassword()));
        User user = userDAO.save(UserMapper.convertUserApiToEntity(userApi));
        return UserMapper.convertEntityToUserApi(user);
    }

    public List<UserApi> getAllUsers() {
        return UserMapper.convertEntitiesToUserApiList(userDAO.findAll());
    }

    public Optional<UserApi> getUserById(String id){
        Optional<User> userOptional = userDAO.findById(id);
        return userOptional.map(UserMapper::convertEntityToUserApi);
    }

    public UserApi modifyUser(UserApi userApi) {
        Optional<User> userOptional = userDAO.findById(userApi.getId());
        if(userOptional.isPresent()) {
            User user = userOptional.get();
            UserMapper.setUserEntity(user, userApi);
            return UserMapper.convertEntityToUserApi(user);
        } else {
            return null;
        }
    }

    public Optional<UserApi> deleteUser(String id) {
        Optional<UserApi> userApi = Optional.empty();
        Optional<User> userOptional = userDAO.findById(id);
        if(userOptional.isPresent()) {
            userApi = Optional.of(UserMapper.convertEntityToUserApi(userOptional.get()));
            userDAO.deleteById(id);
        }
        return userApi;
    }


}
