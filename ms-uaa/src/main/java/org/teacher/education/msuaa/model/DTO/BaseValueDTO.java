package org.teacher.education.msuaa.model.DTO;


import lombok.Data;
import org.teacher.education.msuaa.model.base.BaseEntityDTO;

@Data
public class BaseValueDTO extends BaseEntityDTO {
    private Long id;
    private String name;
    private String engName;
    private Double priority;
    private Double parentId;
    private BaseValueTypeDTO baseValueType;
}
