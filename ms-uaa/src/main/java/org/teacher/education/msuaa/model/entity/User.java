package org.teacher.education.msuaa.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.teacher.education.msuaa.model.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "user")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

    @Column(name = "UserName")
    private String username;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "MobileNumber")
    private String mobileNumber;
    @Column(name = "Email")
    private String email;
    @Column(name = "NationalCode")
    private String nationalCode;
    @Column(name = "UseLastRole")
    private Boolean useLastRole;
    @Column(name = "Gender")
    private Boolean gender;
    @Column(name = "Completed")
    private Boolean completed;
    @Column(name = "Password")
    private String password;
    @Column(name = "HasPassword")
    private Boolean hasPassword;
    @Column(name = "ChangePasswordDate")
    private Timestamp changePasswordDate;
    @Column(name = "ShahkarVerified")
    private Boolean shahkarVerified;
    @Column(name = "OrganizationId")
    private Integer organizationId;
    @Column(name = "OrganizationTitle")
    private String organizationTitle;
    @Column(name = "Enabled")
    private Boolean enabled;
    @Column(name = "BirthDate")
    private Date birthDate;

    @Column(name = "Address")
    private String address;
    @Column(name = "PostalCode")
    private Long postalCode;
    @Column(name = "Nationality")
    private String nationality;
    @Column(name = "PhoneNumber")
    private String phoneNumber;
    private Integer cityId;
    private Integer ProvinceId;
}
