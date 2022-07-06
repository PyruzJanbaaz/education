package org.teacher.education.msuaa.service.impl;

import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.teacher.education.msuaa.mapper.UserMapper;
import org.teacher.education.msuaa.model.DTO.UserDTO;
import org.teacher.education.msuaa.model.base.BaseDTO;
import org.teacher.education.msuaa.repository.UserRepository;
import org.teacher.education.msuaa.service.intrface.UserService;
import org.teacher.education.msuaa.utility.ApplicationProperties;


@Service
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;
    final ApplicationProperties applicationProperties;
    final Logger logger;
    final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, ApplicationProperties applicationProperties, Logger logger, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.applicationProperties = applicationProperties;
        this.logger = logger;
        this.userMapper = userMapper;
    }

    @Override
    public BaseDTO getAllUsers() {
        return null;
    }

    @Override
    public BaseDTO getUserById(Long id) {
        return null;
    }

    @Override
    public BaseDTO addUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public BaseDTO updateUser(UserDTO userDTO, Long id) {
        return null;
    }

    @Override
    public BaseDTO deleteUser(Long id) {
        return null;
    }
}
