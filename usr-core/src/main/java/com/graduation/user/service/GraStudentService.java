package com.graduation.user.service;

import com.graduation.user.tables.daos.GraStudentEntityDao;
import com.graduation.user.tables.pojos.GraStudentEntity;
import com.graduation.user.repo.GraStudentRepo;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangxue
 * @date 2021.2.28 18：46 pm
 */
@Service
public class GraStudentService {
    @Autowired
    private DSLContext dslContext;
    @Autowired
    private GraStudentEntityDao graStudentEntityDao;
    @Autowired
    private GraStudentRepo graStudentRepo;

    public GraStudentEntity getStudentByStuId(String stuId){
        List<GraStudentEntity> entities = graStudentEntityDao.fetchByStuId(stuId);
        if (entities != null && entities.size() != 0){
            return entities.get(0);
        }
        return null;
    }
}
