package com.graduation.user.config;

import com.graduation.user.tables.daos.GraStudentEntityDao;
import org.jooq.DSLContext;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

/**
 * @author zhangxue
 * @date 2021.2.28 18:21 pm
 */
@Component
public class JooqDaoScanConfig implements BeanFactoryAware, BeanDefinitionRegistryPostProcessor,
        BeanPostProcessor, PriorityOrdered {
    private BeanFactory beanFactory;
    private int order = Ordered.LOWEST_PRECEDENCE - 30;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    /**
     * 将jooqGenerator生成的DAO bean定义加入到Spring容器之中
     * @param registry
     * @throws BeansException
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(registry, false);
        scanner.setBeanNameGenerator(((beanDefinition, beanDefinitionRegistry) ->
                "jooq" + ClassUtils.getShortName(beanDefinition.getBeanClassName())));
        scanner.addIncludeFilter(((metadataReader, metadataReaderFactory) ->
                "org.jooq.impl.DAOImpl".equals(metadataReader.getClassMetadata().getSuperClassName())));
        scanner.scan("com.graduation.user");
        System.out.println("我被调用了吗？");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof DAOImpl){
            DSLContext dslContext = beanFactory.getBean(DSLContext.class);
            System.out.println(bean.getClass().getSimpleName() + "0000000000000000000000");
            ((DAOImpl) bean).setConfiguration(dslContext.configuration());
        }
        return null;
    }

    @Override
    public int getOrder() {
        return this.order;
    }
}
