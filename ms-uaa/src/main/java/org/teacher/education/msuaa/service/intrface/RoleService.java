package org.teacher.education.msuaa.service.intrface;

import org.teacher.education.msuaa.model.DTO.RoleDTO;
import org.teacher.education.msuaa.model.base.BaseDTO;

public interface RoleService {
    BaseDTO getAllRoles();
    BaseDTO getRoleById(Long id);
    BaseDTO addRole(RoleDTO roleDTO);
    BaseDTO updateRole(RoleDTO roleDTO,Long id);
    BaseDTO deleteRole(Long id);
}
