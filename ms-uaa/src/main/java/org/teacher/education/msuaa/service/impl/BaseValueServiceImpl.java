package org.teacher.education.msuaa.service.impl;


import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.teacher.education.msuaa.exception.GlobalExceptionHandler;
import org.teacher.education.msuaa.exception.ResourceNotFoundException;
import org.teacher.education.msuaa.mapper.BaseValueMapper;
import org.teacher.education.msuaa.mapper.BaseValueTypeRepository;
import org.teacher.education.msuaa.model.DTO.BaseValueDTO;
import org.teacher.education.msuaa.model.base.BaseDTO;
import org.teacher.education.msuaa.model.base.MetaDTO;
import org.teacher.education.msuaa.model.entity.BaseValue;
import org.teacher.education.msuaa.model.entity.BaseValueType;
import org.teacher.education.msuaa.repository.BaseValueRepository;
import org.teacher.education.msuaa.service.intrface.BaseValueService;
import org.teacher.education.msuaa.utility.ApplicationProperties;


import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Service
public class BaseValueServiceImpl implements BaseValueService {

    final Logger logger;
    final BaseValueRepository baseValueRepository;
    final ApplicationProperties applicationProperties;
    final BaseValueTypeRepository baseValueTypeRepository;
    final BaseValueMapper baseValueMapper;

    public BaseValueServiceImpl(Logger logger, BaseValueRepository baseValueRepository, ApplicationProperties applicationProperties,
                                BaseValueTypeRepository baseValueTypeRepository, BaseValueMapper baseValueMapper) {
        this.logger = logger;
        this.baseValueRepository = baseValueRepository;
        this.applicationProperties = applicationProperties;
        this.baseValueTypeRepository = baseValueTypeRepository;
        this.baseValueMapper = baseValueMapper;
    }

    @Override
    public BaseDTO getAllBaseValues() {
        List<BaseValue> baseValueList = baseValueRepository.findAllByIsDeletedFalse();
        List<BaseValueDTO> baseValueDTOS = baseValueMapper.DTO_LIST(baseValueList);
        return new BaseDTO(MetaDTO.getInstance(applicationProperties), baseValueDTOS);
    }

    @Override
    public BaseDTO getBaseValue(Long id) {
        BaseValue baseValue = baseValueRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new GlobalExceptionHandler(applicationProperties.getProperty("application.message.notfound.text")));
        BaseValueDTO baseValueDTO = baseValueMapper.BASE_VALUE_DTO(baseValue);
        return new BaseDTO(MetaDTO.getInstance(applicationProperties), baseValueDTO);

    }

    @Override
    @Transactional
    public BaseDTO addBaseValue(BaseValueDTO baseValueDTO) {

        BaseValue newBaseValue = BaseValue.builder()
                .name(baseValueDTO.getName())
                .engName(baseValueDTO.getEngName())
                .priority(baseValueDTO.getPriority())
                .parentId(baseValueDTO.getParentId())
                .creatorUserId(baseValueDTO.getCreatorUserId())
                .baseValueType(baseValueTypeRepository.getByIdAndIsDeletedFalse(baseValueDTO.getBaseValueType().getId()))
                .build();
        newBaseValue.setCreatorUserId(baseValueDTO.getCreatorUserId());
        baseValueRepository.save(newBaseValue);
        return new BaseDTO(MetaDTO.getInstance(applicationProperties), baseValueDTO);
    }

    @Override
    public BaseDTO updateBaseValue(BaseValueDTO baseValueDTO, Long id) {

        BaseValue baseValue = baseValueRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new GlobalExceptionHandler(applicationProperties.getProperty("application.message.notfound.text")));
        baseValue.setModifyDateTime(new Timestamp(System.currentTimeMillis()));
        baseValue.setEngName(baseValueDTO.getEngName());
        baseValue.setName(baseValueDTO.getName());
        baseValue.setParentId(baseValueDTO.getParentId());
        baseValue.setPriority(baseValueDTO.getPriority());
        BaseValueType baseValueType = baseValueTypeRepository.findByIdAndIsDeletedFalse(baseValueDTO.getBaseValueType().getId())
                .orElseThrow(() -> new ResourceNotFoundException(applicationProperties.getProperty("application.message.notfound.text")));
        baseValue.setBaseValueType(baseValueType);
        baseValueRepository.save(baseValue);
        return new BaseDTO(MetaDTO.getInstance(applicationProperties), baseValueDTO);

    }

    @Override
    public BaseDTO deleteBaseValue(Long id) {
        BaseValue baseValue = baseValueRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new GlobalExceptionHandler(applicationProperties.getProperty("application.message.notfound.text")));
        baseValue.setIsDeleted(true);
        baseValue.setModifyDateTime(new Timestamp(System.currentTimeMillis()));
        baseValueRepository.save(baseValue);
        BaseValueDTO baseValueDTO = baseValueMapper.BASE_VALUE_DTO(baseValue);

        return new BaseDTO(MetaDTO.getInstance(applicationProperties), baseValueDTO);
    }

    @Override
    public BaseDTO getValue(Long baseValueTypeId) {

        BaseValueType baseValueType = baseValueTypeRepository.getByIdAndIsDeletedFalse(baseValueTypeId);
        List<BaseValue> baseValues = baseValueRepository.findAllByBaseValueType_IdAndIsDeletedFalse(baseValueType.getId());
        List<BaseValueDTO> baseValueDTOS = baseValueMapper.DTO_LIST(baseValues);

        return new BaseDTO(MetaDTO.getInstance(applicationProperties), baseValueDTOS);
    }

    @Override
    public BaseDTO getMounths(Long baseValueTypeId) {

        BaseValueType baseValueType = baseValueTypeRepository.getByIdAndIsDeletedFalse(baseValueTypeId);
        List<BaseValue> baseValues = baseValueRepository.findAllByBaseValueType_IdAndIsDeletedFalse(baseValueType.getId());
        List<BaseValueDTO> baseValueDTOS = baseValueMapper.DTO_LIST(baseValues);

        return new BaseDTO(MetaDTO.getInstance(applicationProperties), baseValueDTOS);
    }

    @Override
    public BaseDTO getYears(Long baseValueTypeId) {

        BaseValueType baseValueType = baseValueTypeRepository.getByIdAndIsDeletedFalse(baseValueTypeId);
        List<BaseValue> baseValues = baseValueRepository.findAllByBaseValueType_IdAndIsDeletedFalse(baseValueType.getId());
        List<BaseValueDTO> baseValueDTOS = baseValueMapper.DTO_LIST(baseValues);

        return new BaseDTO(MetaDTO.getInstance(applicationProperties), baseValueDTOS);
    }

    @Override
    public BaseDTO getSeason(Long baseValueTypeId) {
        BaseValueType baseValueType = baseValueTypeRepository.getByIdAndIsDeletedFalse(baseValueTypeId);
        List<BaseValue> baseValues = baseValueRepository.findAllByBaseValueType_IdAndIsDeletedFalse(baseValueType.getId());
        List<BaseValueDTO> baseValueDTOS = baseValueMapper.DTO_LIST(baseValues);

        return new BaseDTO(MetaDTO.getInstance(applicationProperties), baseValueDTOS);
    }


}
