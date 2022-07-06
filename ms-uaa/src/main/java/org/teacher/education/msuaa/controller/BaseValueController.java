package org.teacher.education.msuaa.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.teacher.education.msuaa.model.DTO.BaseValueDTO;
import org.teacher.education.msuaa.model.base.BaseDTO;

@RestController
@RequestMapping("/api")
public class BaseValueController extends BaseController{


    @GetMapping(value = "/v1/BaseValues", name = "${service.BaseValue.getAll}")
    public ResponseEntity<?> getAllBaseValue() {
        BaseDTO baseDTO = baseValueService.getAllBaseValues();
        return new ResponseEntity<>(baseDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/v1/BaseValue", name = "${service.BaseValue.get}")
    public ResponseEntity<?> getBaseValue(@RequestParam Long id) {
        BaseDTO baseDTO = baseValueService.getBaseValue(id);
        return new ResponseEntity<>(baseDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/v1/BaseValue", name = "${service.BaseValue.add}")
    public ResponseEntity<?> addBaseValue(@RequestBody BaseValueDTO baseValueDTO) {
        BaseDTO baseDTO = baseValueService.addBaseValue(baseValueDTO);
        return new ResponseEntity<>(baseDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/v1/BaseValue", name = "${service.BaseValue.update}")
    public ResponseEntity<?> updateBaseValue(@RequestParam Long id, @RequestBody BaseValueDTO baseValueDTO) {
        BaseDTO baseDTO = baseValueService.updateBaseValue(baseValueDTO, id);
        return new ResponseEntity<>(baseDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/v1/BaseValue", name = "${service.BaseValue.delete}")
    public ResponseEntity<?> deleteBaseValue(@RequestParam Long id) {
        BaseDTO baseDTO = baseValueService.deleteBaseValue(id);
        return new ResponseEntity<>(baseDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/v1/getValue", name = "${service.BaseValue.getValue}")
    public ResponseEntity<?> getValue(@RequestParam Long id) {
        BaseDTO baseDTO = baseValueService.getValue(id);
        return new ResponseEntity<>(baseDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/v1/getYears", name = "${service.BaseValue.getYears}")
    public ResponseEntity<?> getYears() {
        BaseDTO baseDTO = baseValueService.getYears(1L);
        return new ResponseEntity<>(baseDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/v1/getMonths", name = "${service.BaseValue.getMonths}")
    public ResponseEntity<?> getMonths() {
        BaseDTO baseDTO = baseValueService.getMonths(2L);
        return new ResponseEntity<>(baseDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/v1/getSeason", name = "${service.BaseValue.getSeason}")
    public ResponseEntity<?> getSeason() {
        BaseDTO baseDTO = baseValueService.getSeason(3L);
        return new ResponseEntity<>(baseDTO, HttpStatus.OK);
    }
}
