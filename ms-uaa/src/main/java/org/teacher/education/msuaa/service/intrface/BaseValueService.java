package org.teacher.education.msuaa.service.intrface;


import org.teacher.education.msuaa.model.DTO.BaseValueDTO;
import org.teacher.education.msuaa.model.base.BaseDTO;

public interface BaseValueService {

    BaseDTO getAllBaseValues();

    BaseDTO getBaseValue(Long id);

    BaseDTO addBaseValue(BaseValueDTO baseValueDTO);

    BaseDTO updateBaseValue(BaseValueDTO baseValueDTO, Long id);

    BaseDTO deleteBaseValue(Long id);

    BaseDTO getValue(Long baseValueTypeId);

    BaseDTO getMonths(Long baseValueTypeId);

    BaseDTO getYears(Long baseValueTypeId);

    BaseDTO getSeason(Long baseValueTypeId);

}
