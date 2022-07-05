package org.teacher.education.msuaa.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.teacher.education.msuaa.model.base.BaseEntity;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "baseValue")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BaseValue extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "engName")
    private String engName;

    @Column(name = "priority")
    private Double priority;

    @Column(name = "parentId")
    private Double parentId;

    @ToString.Exclude
    @JsonBackReference
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "baseValueType_id", referencedColumnName = "id")
    private BaseValueType baseValueType;

}
