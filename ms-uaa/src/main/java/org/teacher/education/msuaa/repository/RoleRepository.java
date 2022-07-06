package org.teacher.education.msuaa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.teacher.education.msuaa.model.entity.RoleEntity;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity,Long> {

    List<RoleEntity> findAllByIsDeletedFalse();
    Optional<RoleEntity> findByIdAndIsDeletedFalse(Long aLong);
}
