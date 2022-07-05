package org.teacher.education.msuaa.model.DTO;

import lombok.Data;
import org.teacher.education.msuaa.model.base.BaseEntityDTO;


@Data
public class RoleDTO extends BaseEntityDTO {

    private Integer id;
    private String title;
    private String description;

    public RoleDTO() {
    }

    public RoleDTO(Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
}
