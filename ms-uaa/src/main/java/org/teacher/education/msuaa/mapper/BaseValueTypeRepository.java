package org.teacher.education.msuaa.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.teacher.education.msuaa.model.entity.BaseValueType;

import java.util.List;
import java.util.Optional;

public interface BaseValueTypeRepository extends JpaRepository<BaseValueType,Long> {
    List<BaseValueType> findAllByIsDeletedFalse();
    Optional<BaseValueType> findByIdAndIsDeletedFalse(Long id);
    BaseValueType getByIdAndIsDeletedFalse(Long id);

}