package cn.dlj1.blog.core.repository.impl;

import cn.dlj1.blog.core.repository.ExtJpaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.beans.FeatureDescriptor;
import java.io.Serializable;
import java.util.stream.Stream;

public class SimpleExtJpaRepository<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements ExtJpaRepository<T, ID> {

    private final EntityManager em;

    public SimpleExtJpaRepository(JpaEntityInformation<T, ?> entityInformation, EntityManager em) {
        super(entityInformation, em);
        this.em = em;
    }

    public SimpleExtJpaRepository(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.em = em;
    }

    @Override
    @Transactional
    public T dynamicUpdate(ID id, T entity) {
        T managedEntity = this.getOne(id);
        T mergedEntity;
        if (managedEntity == null) {
            em.persist(entity);
            mergedEntity = entity;
        } else {
            BeanUtils.copyProperties(entity, managedEntity, getNullPropertyNames(entity));
            em.merge(managedEntity);
            mergedEntity = managedEntity;
        }
        return mergedEntity;
    }

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Stream.of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null)
                .toArray(String[]::new);
    }

}
