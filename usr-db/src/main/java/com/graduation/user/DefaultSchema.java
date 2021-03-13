/*
 * This file is generated by jOOQ.
 */
package com.graduation.user;


import com.graduation.user.tables.GraCollege;
import com.graduation.user.tables.GraMajor;
import com.graduation.user.tables.GraPermission;
import com.graduation.user.tables.GraRole;
import com.graduation.user.tables.GraStudent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DefaultSchema extends SchemaImpl {

    private static final long serialVersionUID = -1087265951;

    /**
     * The reference instance of <code></code>
     */
    public static final DefaultSchema DEFAULT_SCHEMA = new DefaultSchema();

    /**
     * 学院表
     */
    public final GraCollege GRA_COLLEGE = com.graduation.user.tables.GraCollege.GRA_COLLEGE;

    /**
     * 专业表
     */
    public final GraMajor GRA_MAJOR = com.graduation.user.tables.GraMajor.GRA_MAJOR;

    /**
     * The table <code>gra_permission</code>.
     */
    public final GraPermission GRA_PERMISSION = com.graduation.user.tables.GraPermission.GRA_PERMISSION;

    /**
     * The table <code>gra_role</code>.
     */
    public final GraRole GRA_ROLE = com.graduation.user.tables.GraRole.GRA_ROLE;

    /**
     * 学生表
     */
    public final GraStudent GRA_STUDENT = com.graduation.user.tables.GraStudent.GRA_STUDENT;

    /**
     * No further instances allowed
     */
    private DefaultSchema() {
        super("", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            GraCollege.GRA_COLLEGE,
            GraMajor.GRA_MAJOR,
            GraPermission.GRA_PERMISSION,
            GraRole.GRA_ROLE,
            GraStudent.GRA_STUDENT);
    }
}
