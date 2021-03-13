package com.graduation.user.config;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

/**
 * @author zhangxue
 * @date 2021.2.28 18:33 pm
 */
@Configuration
@Import(DBConfig.class)
public class JooqConfig {
    /**
     * 将DSLContext加入Spring容器
     * @param dataSource
     * @return
     */
    @Bean
    @ConditionalOnBean(DataSource.class)
    public DSLContext dslContext(DataSource dataSource) {

        return new DefaultDSLContext(dataSource, SQLDialect.MYSQL);
    }
}
