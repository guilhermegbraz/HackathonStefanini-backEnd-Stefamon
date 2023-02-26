package com.stefanini.dataproviders.repository;


import com.stefanini.dataproviders.dao.GenericDAO;
import com.stefanini.dataproviders.entity.StefamonEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StefamonRepository extends GenericDAO<StefamonEntity, Long> {
}
