/*
 * This file is generated by jOOQ.
 */
package com.graduation.user;


import com.graduation.user.tables.GraCollege;
import com.graduation.user.tables.GraMajor;
import com.graduation.user.tables.GraPermission;
import com.graduation.user.tables.GraRole;
import com.graduation.user.tables.GraStudent;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in 
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * 学院表
     */
    public static final GraCollege GRA_COLLEGE = com.graduation.user.tables.GraCollege.GRA_COLLEGE;

    /**
     * 专业表
     */
    public static final GraMajor GRA_MAJOR = com.graduation.user.tables.GraMajor.GRA_MAJOR;

    /**
     * The table <code>gra_permission</code>.
     */
    public static final GraPermission GRA_PERMISSION = com.graduation.user.tables.GraPermission.GRA_PERMISSION;

    /**
     * The table <code>gra_role</code>.
     */
    public static final GraRole GRA_ROLE = com.graduation.user.tables.GraRole.GRA_ROLE;

    /**
     * 学生表
     */
    public static final GraStudent GRA_STUDENT = com.graduation.user.tables.GraStudent.GRA_STUDENT;
}
