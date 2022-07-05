package org.teacher.education.msuaa.model.DTO;


import lombok.Data;
import org.teacher.education.msuaa.model.base.BaseEntityDTO;

@Data
public class BaseValueTypeDTO extends BaseEntityDTO {

    private Long id;
    private String typeName;
    private String typeEngName;
    private Long parentID;
    private Boolean isEditable;
}
