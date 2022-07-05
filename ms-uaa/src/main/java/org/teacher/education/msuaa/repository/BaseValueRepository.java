package org.teacher.education.msuaa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.teacher.education.msuaa.model.entity.BaseValue;

import java.util.List;
import java.util.Optional;
public interface BaseValueRepository extends JpaRepository<BaseValue,Long> {
    List<BaseValue> findAllByIsDeletedFalse();
    List<BaseValue> findAllByBaseValueType_IdAndIsDeletedFalse(Long baseValueTypeId);
    Optional<BaseValue> findByIdAndIsDeletedFalse(Long aLong);
}