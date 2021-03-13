/*
 * This file is generated by jOOQ.
 */
package com.graduation.user.tables.daos;


import com.graduation.user.tables.GraPermission;
import com.graduation.user.tables.pojos.GraPermissionEntity;
import com.graduation.user.tables.records.GraPermissionRecord;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


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
public class GraPermissionEntityDao extends DAOImpl<GraPermissionRecord, GraPermissionEntity, Integer> {

    /**
     * Create a new GraPermissionEntityDao without any configuration
     */
    public GraPermissionEntityDao() {
        super(GraPermission.GRA_PERMISSION, GraPermissionEntity.class);
    }

    /**
     * Create a new GraPermissionEntityDao with an attached configuration
     */
    public GraPermissionEntityDao(Configuration configuration) {
        super(GraPermission.GRA_PERMISSION, GraPermissionEntity.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getId(GraPermissionEntity object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<GraPermissionEntity> fetchById(Integer... values) {
        return fetch(GraPermission.GRA_PERMISSION.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public GraPermissionEntity fetchOneById(Integer value) {
        return fetchOne(GraPermission.GRA_PERMISSION.ID, value);
    }

    /**
     * Fetch records that have <code>permission IN (values)</code>
     */
    public List<GraPermissionEntity> fetchByPermission(String... values) {
        return fetch(GraPermission.GRA_PERMISSION.PERMISSION, values);
    }

    /**
     * Fetch records that have <code>role_id IN (values)</code>
     */
    public List<GraPermissionEntity> fetchByRoleId(Integer... values) {
        return fetch(GraPermission.GRA_PERMISSION.ROLE_ID, values);
    }

    /**
     * Fetch records that have <code>role_name IN (values)</code>
     */
    public List<GraPermissionEntity> fetchByRoleName(String... values) {
        return fetch(GraPermission.GRA_PERMISSION.ROLE_NAME, values);
    }

    /**
     * Fetch records that have <code>ctime IN (values)</code>
     */
    public List<GraPermissionEntity> fetchByCtime(Timestamp... values) {
        return fetch(GraPermission.GRA_PERMISSION.CTIME, values);
    }

    /**
     * Fetch records that have <code>mtime IN (values)</code>
     */
    public List<GraPermissionEntity> fetchByMtime(Timestamp... values) {
        return fetch(GraPermission.GRA_PERMISSION.MTIME, values);
    }
}
