package org.teacher.education.msuaa.mapper;


import org.mapstruct.Mapper;
import org.teacher.education.msuaa.model.DTO.BaseValueDTO;
import org.teacher.education.msuaa.model.entity.BaseValue;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BaseValueMapper {
    //BaseValueMapper Instanse=Mappers.getMapper(BaseValueMapper.class);
    List<BaseValueDTO> DTO_LIST(List<BaseValue> baseValueList);
    BaseValueDTO BASE_VALUE_DTO(BaseValue baseValue);

}