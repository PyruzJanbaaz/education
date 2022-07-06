package org.teacher.education.msuaa.service.intrface;

import org.teacher.education.msuaa.model.DTO.UserDTO;
import org.teacher.education.msuaa.model.base.BaseDTO;

public interface UserService {

    BaseDTO getAllUsers();
    BaseDTO getUserById(Long id);
    BaseDTO addUser(UserDTO userDTO);
    BaseDTO updateUser(UserDTO userDTO,Long id);
    BaseDTO deleteUser(Long id);
}
