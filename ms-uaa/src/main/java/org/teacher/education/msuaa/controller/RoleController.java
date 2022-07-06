package org.teacher.education.msuaa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.teacher.education.msuaa.model.DTO.BaseValueDTO;
import org.teacher.education.msuaa.model.DTO.RoleDTO;
import org.teacher.education.msuaa.model.base.BaseDTO;


@RestController
@RequestMapping("/api")
public class RoleController extends BaseController{

    @GetMapping(value = "v1/roles", name = "${service.roles.getRoles}")
    public ResponseEntity<?> getRoles(){
        BaseDTO baseDTO = roleService.getAllRoles();
        return new ResponseEntity<>(baseDTO, HttpStatus.OK);
    }

    @GetMapping(value = "v1/roles", name = "${service.roles.get}")
    public ResponseEntity<?> getRoleById(@RequestParam Long id){
        BaseDTO baseDTO = roleService.getRoleById(id);
        return new ResponseEntity<>(baseDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/v1/roles", name = "${service.roles.add}")
    public ResponseEntity<?> addRole(@RequestBody RoleDTO roleDTO) {
        BaseDTO baseDTO = roleService.addRole(roleDTO);
        return new ResponseEntity<>(baseDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/v1/roles", name = "${service.roles.update}")
    public ResponseEntity<?> updateRole(@RequestParam Long id, @RequestBody RoleDTO roleDTO) {
        BaseDTO baseDTO = roleService.updateRole(roleDTO, id);
        return new ResponseEntity<>(baseDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/v1/roles", name = "${service.roles.delete}")
    public ResponseEntity<?> deleteRole(@RequestParam Long id) {
        BaseDTO baseDTO = roleService.deleteRole(id);
        return new ResponseEntity<>(baseDTO, HttpStatus.OK);
    }

}
