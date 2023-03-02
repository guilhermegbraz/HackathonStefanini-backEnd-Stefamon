package com.stefanini.dataproviders.repository;


import com.stefanini.core.entidades.Stefamon;
import com.stefanini.core.repositorios.StefamonRepository;
import com.stefanini.dataproviders.dao.GenericDAO;
import com.stefanini.dataproviders.entity.StefamonEntity;
import com.stefanini.dataproviders.parsers.StefamonEntityToStefamon;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class JPAStefamonRepository extends GenericDAO<StefamonEntity, Long> implements StefamonRepository {
    @Inject
    StefamonEntityToStefamon stefamonEntityToStefamon;

    @Override
    public Stefamon pegarStefamonPorId(Long id) {
        StefamonEntity stefamonEntity = this.findById(id);
        if (stefamonEntity == null) return null;
        return this.stefamonEntityToStefamon.execute(stefamonEntity);
    }
}
