package org.teacher.education.msuaa.mapper;


import org.mapstruct.Mapper;
import org.teacher.education.msuaa.model.DTO.RoleDTO;
import org.teacher.education.msuaa.model.entity.RoleEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleEntityMapper {

    RoleDTO ROLE_DTO(RoleEntity roleEntity);
    List<RoleDTO> ROLE_DTO_LIST(List<RoleEntity> roleEntityList);
}
