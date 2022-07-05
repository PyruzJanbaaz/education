package org.teacher.education.msuaa.model.DTO;

import lombok.Data;

import javax.validation.constraints.*;
import java.util.List;

@Data
public class UserDTO {

    @Size(max = 45, message = "{validation.message.incorrect.length}")
    private String firstName;

    @Size(max = 45, message = "{validation.message.incorrect.length}")
    private String lastName;

    private Long companyId;

    @NotBlank
    @Size(max = 45, message = "{validation.message.incorrect.length}")
    @Pattern(regexp = "^[0-9a-zA-Z\\-_.@]{3,}$", message = "{application.message.validationError.text}")
    private String username;

    @Size(max = 45)
    private String nationality;

    private Short gender;

    private Boolean completed;

    @Size(max = 45, message = "{validation.message.incorrect.length}")
    @Email
    private String email;

    @NotBlank
    @Size(min = 5, message = "{validation.message.incorrect.length}")
    private String password;

    @NotBlank
    private String confirmPassword;

    @Pattern(regexp = "^(09|989)\\d{9}$", message = "{application.message.validationError.text}")
    private String mobileNumber;

    @Size(min = 4, max = 12, message = "{validation.message.incorrect.length}")
    @Pattern(regexp = "^([0-9]*)$", message = "{application.message.validationError.text}")
    private String phoneNumber;

    @Size(min = 10, max = 10)
    @Pattern(regexp = "^([0-9]*)$", message = "{application.message.validationError.text}")
    private String nationalCode;

    @Min(value = 999999999, message = "{application.message.validationerror.text}")
    @Max(value = 9999999999L, message = "{application.message.validationError.text}")
    private Long postalCode;

    //@NotBlank
    @Size(max = 250, message = "{validation.message.incorrect.length}")
    private String address;

    private Long birthDate;

    private Integer cityId;
    private Integer ProvinceId;

    //@NotNull
    private Integer userTypeId;

    private List<Integer> roleIds;

    //private Boolean deleted = false;

    private Boolean enabled = true;
}
