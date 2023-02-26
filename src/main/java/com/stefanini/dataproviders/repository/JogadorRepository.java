package com.stefanini.dataproviders.repository;

import com.stefanini.dataproviders.dao.GenericDAO;

import com.stefanini.dataproviders.entity.JogadorEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JogadorRepository extends GenericDAO<JogadorEntity, Long> {
}
