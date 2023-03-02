package com.stefanini.service;

import com.stefanini.dataproviders.entity.StefamonEntity;
import com.stefanini.core.exceptions.RegraDeNegocioException;
import com.stefanini.dataproviders.repository.JPAStefamonRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class StefamonService {

    @Inject
    JPAStefamonRepository repository;

    public List<StefamonEntity> listarTodos(){
        return repository.listAll();
    }

    public StefamonEntity pegarPorId(Long id) {
        var stefamon =  repository.findById(id);
        if(Objects.isNull(stefamon)) {
            throw new RegraDeNegocioException("Não encontramos nada com o id " + id, Response.Status.NOT_FOUND);
        }
        return stefamon;
    }

 }
