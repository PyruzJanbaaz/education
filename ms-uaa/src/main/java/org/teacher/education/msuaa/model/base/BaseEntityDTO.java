package org.teacher.education.msuaa.model.base;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;
import java.util.Date;


@Data
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BaseEntityDTO {
    private Boolean isDeleted=false;
    private Date createDateTime = new Timestamp(System.currentTimeMillis());
    private Date modifyDateTime= new Timestamp(System.currentTimeMillis());
    private Long creatorUserId;
}
