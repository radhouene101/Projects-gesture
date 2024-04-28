package tn.bal.pi.controllers;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.bal.pi.dto.UserDto;
import tn.bal.pi.services.IUserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
@Tag(name = "user")
public class UserController {
    @Autowired
    private final IUserService service;
    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto user){

        return ResponseEntity.ok(service.save(user));
    }
    @GetMapping
    public ResponseEntity<List<UserDto>> findAll(){
        return ResponseEntity.
                ok(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id){
        return ResponseEntity.
                ok(service.findById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
            service.delete(id);
            return ResponseEntity.ok().build();
    }
    @PatchMapping("/validate-user/{id}")
    public ResponseEntity<Long> validateAccount(@PathVariable Long id){
        return ResponseEntity.ok(service.validateAccount(id));
    }
    @PatchMapping("/invalidate-user/{id}")
    public ResponseEntity<Long> invalidateAccount(@PathVariable Long id){
        return ResponseEntity.ok(service.invalidateAccount(id));
    }

}
