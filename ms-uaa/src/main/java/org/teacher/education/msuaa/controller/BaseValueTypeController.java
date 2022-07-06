package org.teacher.education.msuaa.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.teacher.education.msuaa.model.DTO.BaseValueTypeDTO;
import org.teacher.education.msuaa.model.base.BaseDTO;

@RestController
@RequestMapping("/api")
public class BaseValueTypeController extends BaseController{

    @GetMapping(value = "/v1/BaseValueTypes", name = "${service.BaseValueType.getAll}")
    public ResponseEntity<?> getAllBaseValueType() {
        BaseDTO baseDTO = baseValueTypeService.getAllBaseValueType();
        return new ResponseEntity<>(baseDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/v1/BaseValueType", name = "${service.BaseValueType.get}")
    public ResponseEntity<?> getBaseValueType(@RequestParam Long id) {
        BaseDTO baseDTO = baseValueTypeService.getBaseValueTypeById(id);
        return new ResponseEntity<>(baseDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/v1/BaseValueType", name = "${service.BaseValueType.add}")
    public ResponseEntity<?> addBaseValueType(@RequestBody BaseValueTypeDTO baseValueTypeDTO) {
        BaseDTO baseDTO = baseValueTypeService.addBaseValueType(baseValueTypeDTO);
        return new ResponseEntity<>(baseDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/v1/BaseValueType", name = "${service.BaseValueType.update}")
    public ResponseEntity<?> updateBaseValueType(@RequestParam Long id, @RequestBody BaseValueTypeDTO baseValueTypeDTO) {
        BaseDTO baseDTO = baseValueTypeService.updateBaseValueType(baseValueTypeDTO, id);
        return new ResponseEntity<>(baseDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/v1/BaseValueType", name = "${service.BaseValueType.delete}")
    public ResponseEntity<?> deleteBaseValueType(@RequestParam Long id) {
        BaseDTO baseDTO = baseValueTypeService.deleteBaseValueType(id);
        return new ResponseEntity<>(baseDTO, HttpStatus.OK);

    }
}
