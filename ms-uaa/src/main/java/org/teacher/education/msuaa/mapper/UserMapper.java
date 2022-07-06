package org.teacher.education.msuaa.mapper;


import org.mapstruct.Mapper;
import org.teacher.education.msuaa.model.DTO.UserDTO;
import org.teacher.education.msuaa.model.entity.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO USER_DTO(User user);
    List<UserDTO> USER_DTO_LIST(List<User> userList);
}
