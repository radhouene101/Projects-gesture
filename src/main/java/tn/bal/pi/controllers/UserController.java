package tn.bal.pi.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.bal.pi.entities.User;
import tn.bal.pi.services.IUserService;

@RestController
@AllArgsConstructor
@RequestMapping("user")
public class UserController {
    @Autowired
    IUserService iUserService;
    @PostMapping
    public User saveUser(@RequestBody User user){
        return iUserService.saveUser(user);
    }
}
