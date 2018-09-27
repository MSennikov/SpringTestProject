package com.SennikovTestProject.DemoProject.Services;

import com.SennikovTestProject.DemoProject.DTO.UserDTO;
import com.SennikovTestProject.DemoProject.Entity.User;
import com.SennikovTestProject.DemoProject.Repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRep userRep;


    private List<UserDTO> usersDTO = new ArrayList<>();

    public List<UserDTO> findUserByUserName(String secondName){
        List<User> users = userRep.findBySecondName(secondName);
        for (User user: users){
            UserDTO userDTO = new UserDTO(user);
            usersDTO.add(userDTO);
        }
        return usersDTO;



    }



}
