package org.teacher.education.msuaa.service.intrface;

import org.teacher.education.msuaa.model.DTO.BaseValueTypeDTO;
import org.teacher.education.msuaa.model.base.BaseDTO;

public interface BaseValueTypeService {
    BaseDTO getAllBaseValueType();
    BaseDTO getBaseValueTypeById(Long id);
    BaseDTO addBaseValueType(BaseValueTypeDTO baseValueTypeDTO);
    BaseDTO updateBaseValueType(BaseValueTypeDTO baseValueTypeDTO,Long id);
    BaseDTO deleteBaseValueType(Long id);
}