package org.teacher.education.msuaa.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.teacher.education.msuaa.model.base.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "BaseValueType")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BaseValueType extends BaseEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "Id")
//    private Long id;
    @Column(name = "TypeName")
    private String typeName;
    @Column(name = "TypeEngName")
    private String typeEngName;
    @Column(name = "ParentID")
    private Long parentID;
    @Column(name = "IsEditable")
    private Boolean isEditable;
    @ToString.Exclude
    @JsonManagedReference
    @JsonBackReference
    @OneToMany(mappedBy = "baseValueType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BaseValue> baseValues;

}