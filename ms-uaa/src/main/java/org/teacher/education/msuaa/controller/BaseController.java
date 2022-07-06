package org.teacher.education.msuaa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.teacher.education.msuaa.service.intrface.BaseValueService;
import org.teacher.education.msuaa.service.intrface.BaseValueTypeService;
import org.teacher.education.msuaa.service.intrface.RoleService;
import org.teacher.education.msuaa.service.intrface.UserService;


public class BaseController {

    @Autowired
    protected BaseValueService baseValueService;
    @Autowired
    protected BaseValueTypeService baseValueTypeService;
    @Autowired
    protected RoleService roleService;
    @Autowired
    protected UserService userService;
}
