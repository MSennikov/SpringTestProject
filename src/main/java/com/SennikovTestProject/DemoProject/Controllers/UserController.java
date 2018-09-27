package com.SennikovTestProject.DemoProject.Controllers;

import com.SennikovTestProject.DemoProject.DTO.UserDTO;
import com.SennikovTestProject.DemoProject.Entity.User;
import com.SennikovTestProject.DemoProject.Repository.UserRep;
import com.SennikovTestProject.DemoProject.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRep userRepository;

    @Autowired
    UserService userService;


    @GetMapping(path="/all")
    public List<User> check(){
        return userRepository.findAll();
    }

    @GetMapping(path = "/find/{name}")
    public List<UserDTO> check(@PathVariable("name") String name) throws Exception{
        return userService.findUserByUserName(name);
    }
}
