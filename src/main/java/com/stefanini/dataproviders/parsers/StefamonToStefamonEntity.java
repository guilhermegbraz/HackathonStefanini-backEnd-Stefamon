package com.stefanini.dataproviders.parsers;

import com.stefanini.core.entidades.Stefamon;
import com.stefanini.dataproviders.entity.StefamonEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ApplicationScoped()
public class StefamonToStefamonEntity {
    public StefamonEntity execute(Stefamon stefaMon) {
        return new StefamonEntity(stefaMon.getId(), stefaMon.getNome(), stefaMon.getVida(), stefaMon.getAtaque(),
                stefaMon.getDefesa(), stefaMon.getInteligencia(), stefaMon.getPoder(), stefaMon.getVelocidade(), stefaMon.getUrlFoto());
    }

    public List<StefamonEntity> execute(List<Stefamon> listaStefamons) {
        List<StefamonEntity> stefaMons = new ArrayList<>();
        listaStefamons.forEach(stefaMon -> stefaMons.add((this.execute(stefaMon))));
        return stefaMons;
    }
}
