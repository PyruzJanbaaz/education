package org.teacher.education.msuaa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.teacher.education.msuaa.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findAllByIsDeletedFalse();
    Optional<User> findByIdAndIsDeletedFalse(Long aLong);

}
