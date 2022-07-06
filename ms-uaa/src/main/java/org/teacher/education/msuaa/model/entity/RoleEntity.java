package org.teacher.education.msuaa.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.teacher.education.msuaa.model.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roleEntity")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity extends BaseEntity {

    @Column(name = "Title")
    private String title;

    @Column(name = "Description")
    private String description;

}
