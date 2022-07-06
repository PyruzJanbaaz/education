package org.teacher.education.msuaa.service.impl;

import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.teacher.education.msuaa.exception.GlobalExceptionHandler;
import org.teacher.education.msuaa.mapper.RoleEntityMapper;
import org.teacher.education.msuaa.model.DTO.RoleDTO;
import org.teacher.education.msuaa.model.base.BaseDTO;
import org.teacher.education.msuaa.model.base.MetaDTO;
import org.teacher.education.msuaa.model.entity.RoleEntity;
import org.teacher.education.msuaa.repository.RoleRepository;
import org.teacher.education.msuaa.service.intrface.RoleService;
import org.teacher.education.msuaa.utility.ApplicationProperties;

import java.sql.Timestamp;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    final Logger logger;
    final RoleRepository roleRepository;
    final ApplicationProperties applicationProperties;
    final RoleEntityMapper roleEntityMapper;

    public RoleServiceImpl(Logger logger, RoleRepository roleRepository, ApplicationProperties applicationProperties, RoleEntityMapper roleEntityMapper) {
        this.logger = logger;
        this.roleRepository = roleRepository;
        this.applicationProperties = applicationProperties;
        this.roleEntityMapper = roleEntityMapper;
    }


    @Override
    public BaseDTO getAllRoles() {
        List<RoleEntity> roleEntities=roleRepository.findAllByIsDeletedFalse();
        List<RoleDTO> roleDTOLis=roleEntityMapper.ROLE_DTO_LIST(roleEntities);
        return new BaseDTO(MetaDTO.getInstance(applicationProperties),roleDTOLis);
    }

    @Override
    public BaseDTO getRoleById(Long id) {
        RoleEntity roleEntity=roleRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(()->new GlobalExceptionHandler(applicationProperties.getProperty("application.message.notfound.text")));
        RoleDTO roleDTO=roleEntityMapper.ROLE_DTO(roleEntity);
        return new BaseDTO(MetaDTO.getInstance(applicationProperties),roleDTO);
    }

    @Override
    public BaseDTO addRole(RoleDTO roleDTO) {
        RoleEntity roleEntity= RoleEntity.builder()
                .title(roleDTO.getTitle())
                .description(roleDTO.getDescription())
                .build();
        roleRepository.save(roleEntity);
        return new BaseDTO(MetaDTO.getInstance(applicationProperties),roleDTO);
    }

    @Override
    public BaseDTO updateRole(RoleDTO roleDTO, Long id) {
        RoleEntity roleEntity=roleRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(()->new GlobalExceptionHandler(applicationProperties.getProperty("application.message.notfound.text")));
        roleEntity.setTitle(roleDTO.getTitle());
        roleEntity.setDescription(roleDTO.getDescription());
        roleEntity.setModifyDateTime(new Timestamp(System.currentTimeMillis()));
        roleRepository.save(roleEntity);

        return new BaseDTO(MetaDTO.getInstance(applicationProperties),roleDTO);
    }

    @Override
    public BaseDTO deleteRole(Long id) {
        RoleEntity roleEntity=roleRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(()->new GlobalExceptionHandler(applicationProperties.getProperty("application.message.notfound.text")));
        roleEntity.setIsDeleted(true);
        roleEntity.setModifyDateTime(new Timestamp(System.currentTimeMillis()));
        roleRepository.save(roleEntity);

        RoleDTO roleDTO=roleEntityMapper.ROLE_DTO(roleEntity);
        return new BaseDTO(MetaDTO.getInstance(applicationProperties),roleDTO);

    }
}
