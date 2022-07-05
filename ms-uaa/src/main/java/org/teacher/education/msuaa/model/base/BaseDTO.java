package org.teacher.education.msuaa.model.base;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseDTO<T> {
    private MetaDTO meta;
    private T object;
}
