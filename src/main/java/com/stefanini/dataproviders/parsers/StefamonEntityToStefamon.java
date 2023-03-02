package com.stefanini.dataproviders.parsers;

import com.stefanini.core.entidades.Stefamon;
import com.stefanini.dataproviders.entity.StefamonEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@ApplicationScoped
public class StefamonEntityToStefamon {

    public Stefamon execute(StefamonEntity stefamonEntity) {
        return new Stefamon(stefamonEntity.getId(), stefamonEntity.getNome(), stefamonEntity.getVida(),
                stefamonEntity.getAtaque(), stefamonEntity.getDefesa(), stefamonEntity.getInteligencia(),
                stefamonEntity.getPoder(), stefamonEntity.getVelocidade(), stefamonEntity.getUrlFoto());
    }

    public List<Stefamon> execute(List<StefamonEntity> listaStefamons) {
        List<Stefamon> stefamons = new ArrayList<>();
        listaStefamons.forEach(stefaMon -> stefamons.add((this.execute(stefaMon))));
        return Collections.unmodifiableList(stefamons);
    }
}
