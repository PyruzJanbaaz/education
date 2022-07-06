package org.teacher.education.msuaa.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.teacher.education.msuaa.model.DTO.UserDTO;
import org.teacher.education.msuaa.model.base.BaseDTO;

@RestController
@RequestMapping("/api")
public class UserController extends BaseController{

    @GetMapping(value = "v1/users", name = "${service.user.getUsers}")
    public ResponseEntity<?> getUsers(){
        BaseDTO baseDTO = userService.getAllUsers();
        return new ResponseEntity<>(baseDTO, HttpStatus.OK);
    }

    @GetMapping(value = "v1/user", name = "${service.user.get}")
    public ResponseEntity<?> getUserById(@RequestParam Long id){
        BaseDTO baseDTO = userService.getUserById(id);
        return new ResponseEntity<>(baseDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/v1/user", name = "${service.user.add}")
    public ResponseEntity<?> addUser(@RequestBody UserDTO userDTO) {
        BaseDTO baseDTO = userService.addUser(userDTO);
        return new ResponseEntity<>(baseDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/v1/user", name = "${service.user.update}")
    public ResponseEntity<?> updateUser(@RequestParam Long id, @RequestBody UserDTO userDTO) {
        BaseDTO baseDTO = userService.updateUser(userDTO, id);
        return new ResponseEntity<>(baseDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/v1/user", name = "${service.user.delete}")
    public ResponseEntity<?> deleteUser(@RequestParam Long id) {
        BaseDTO baseDTO = userService.deleteUser(id);
        return new ResponseEntity<>(baseDTO, HttpStatus.OK);
    }

}
