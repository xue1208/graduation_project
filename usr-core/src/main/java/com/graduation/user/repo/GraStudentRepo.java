package com.graduation.user.repo;

import com.graduation.user.tables.daos.GraStudentEntityDao;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author zhangxue
 * @date 2021.2.28 18:53 pm
 * 自定义sql语句
 */
@Repository
public class GraStudentRepo {
    @Autowired
    private DSLContext dslContext;
    @Autowired
    private GraStudentEntityDao graStudentDao;


}
