package org.teacher.education.msuaa.mapper;

import org.mapstruct.Mapper;
import org.teacher.education.msuaa.model.DTO.BaseValueTypeDTO;
import org.teacher.education.msuaa.model.entity.BaseValueType;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BaseValueTypeMapper {

    BaseValueTypeDTO BASE_VALUE_TYPE_DTO(BaseValueType baseValueType);
    List<BaseValueTypeDTO> BASE_VALUE_TYPE_DTOS(List<BaseValueType>baseValueTypeList);
}
