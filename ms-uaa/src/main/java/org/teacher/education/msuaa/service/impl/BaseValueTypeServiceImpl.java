package org.teacher.education.msuaa.service.impl;

import org.springframework.stereotype.Service;
import org.teacher.education.msuaa.exception.GlobalExceptionHandler;
import org.teacher.education.msuaa.mapper.BaseValueTypeMapper;
import org.teacher.education.msuaa.repository.BaseValueTypeRepository;
import org.teacher.education.msuaa.model.DTO.BaseValueTypeDTO;
import org.teacher.education.msuaa.model.base.BaseDTO;
import org.teacher.education.msuaa.model.base.MetaDTO;
import org.teacher.education.msuaa.model.entity.BaseValueType;
import org.teacher.education.msuaa.service.intrface.BaseValueTypeService;
import org.teacher.education.msuaa.utility.ApplicationProperties;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;


@Service
public class BaseValueTypeServiceImpl implements BaseValueTypeService {

    final BaseValueTypeRepository baseValueTypeRepository;
    final ApplicationProperties applicationProperties;
    final BaseValueTypeMapper baseValueTypeMapper;

    public BaseValueTypeServiceImpl(BaseValueTypeRepository baseValueTypeRepository, ApplicationProperties applicationProperties, BaseValueTypeMapper baseValueTypeMapper) {
        this.baseValueTypeRepository = baseValueTypeRepository;
        this.applicationProperties = applicationProperties;
        this.baseValueTypeMapper = baseValueTypeMapper;
    }

    @Override
    public BaseDTO getAllBaseValueType() {
        List<BaseValueType> baseValueTypeList = baseValueTypeRepository.findAllByIsDeletedFalse();
        List<BaseValueTypeDTO> baseValueTypeDTOS = baseValueTypeMapper.BASE_VALUE_TYPE_DTOS(baseValueTypeList);
        return new BaseDTO(MetaDTO.getInstance(applicationProperties), baseValueTypeDTOS);
    }

    @Override
    public BaseDTO getBaseValueTypeById(Long id) {
        BaseValueType baseValueType = baseValueTypeRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new GlobalExceptionHandler(applicationProperties.getProperty("application.message.notfound.text")));
        BaseValueTypeDTO baseValueTypeDTO = baseValueTypeMapper.BASE_VALUE_TYPE_DTO(baseValueType);
        return new BaseDTO(MetaDTO.getInstance(applicationProperties), baseValueTypeDTO);
    }

    @Override
    @Transactional
    public BaseDTO addBaseValueType(BaseValueTypeDTO baseValueTypeDTO) {

        BaseValueType newBaseValueType = BaseValueType.builder()
                .typeEngName(baseValueTypeDTO.getTypeEngName())
                .typeName(baseValueTypeDTO.getTypeName())
                .parentID(baseValueTypeDTO.getParentID())
//                    .creatorUserId(baseValueTypeDTO.getCreatorUserId())
                .isEditable(true)
                .build();
        baseValueTypeRepository.save(newBaseValueType);
        BaseValueTypeDTO baseValueDTO = baseValueTypeMapper.BASE_VALUE_TYPE_DTO(newBaseValueType);
        return new BaseDTO(MetaDTO.getInstance(applicationProperties), baseValueDTO);
    }

    @Override
    @Transactional
    public BaseDTO updateBaseValueType(BaseValueTypeDTO baseValueTypeDTO, Long id) {

        BaseValueType baseValueTypeOld = baseValueTypeRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new GlobalExceptionHandler(applicationProperties.getProperty("application.message.notfound.text")));
        baseValueTypeOld.setTypeName(baseValueTypeDTO.getTypeName());
        baseValueTypeOld.setTypeEngName(baseValueTypeDTO.getTypeEngName());
        baseValueTypeOld.setIsEditable(baseValueTypeDTO.getIsEditable());
        baseValueTypeOld.setModifyDateTime(new Timestamp(System.currentTimeMillis()));
        baseValueTypeOld.setParentID(baseValueTypeDTO.getParentID());
        baseValueTypeRepository.save(baseValueTypeOld);
        BaseValueTypeDTO baseValueDTO = baseValueTypeMapper.BASE_VALUE_TYPE_DTO(baseValueTypeOld);

        return new BaseDTO(MetaDTO.getInstance(applicationProperties), baseValueDTO);

    }

    @Override
    public BaseDTO deleteBaseValueType(Long id) {
        BaseValueType baseValueTypeOld = baseValueTypeRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new GlobalExceptionHandler(applicationProperties.getProperty("application.message.notfound.text")));
        baseValueTypeOld.setIsDeleted(true);
        baseValueTypeOld.setModifyDateTime(new Timestamp(System.currentTimeMillis()));
        baseValueTypeRepository.save(baseValueTypeOld);
        BaseValueTypeDTO baseValueDTO = baseValueTypeMapper.BASE_VALUE_TYPE_DTO(baseValueTypeOld);

        return new BaseDTO(MetaDTO.getInstance(applicationProperties), baseValueDTO);
    }
}
