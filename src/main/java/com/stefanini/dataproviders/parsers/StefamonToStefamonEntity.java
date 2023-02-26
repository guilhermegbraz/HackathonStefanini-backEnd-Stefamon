package com.stefanini.dataproviders.parsers;

import com.stefanini.core.entidades.StefaMon;
import com.stefanini.dataproviders.entity.StefamonEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ApplicationScoped()
public class StefamonToStefamonEntity {
    public StefamonEntity execute(StefaMon stefaMon) {
        return new StefamonEntity(stefaMon.getId(), stefaMon.getNome(), stefaMon.getVida(), stefaMon.getAtaque(),
                stefaMon.getDefesa(), stefaMon.getInteligencia(), stefaMon.getPoder(), stefaMon.getVelocidade(), stefaMon.getUrlFoto());
    }

    public List<StefamonEntity> execute(List<StefaMon> listaStefamons) {
        List<StefamonEntity> stefaMons = new ArrayList<>();
        listaStefamons.forEach(stefaMon -> stefaMons.add((this.execute(stefaMon))));
        return Collections.unmodifiableList(stefaMons);
    }
}
