package com.stefanini.dataproviders.parsers;

import com.stefanini.core.entidades.StefaMon;
import com.stefanini.dataproviders.entity.StefamonEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@ApplicationScoped
public class StefamonEntityToStefamon {

    public StefaMon execute(StefamonEntity stefamonEntity) {
        return new StefaMon(stefamonEntity.getId(), stefamonEntity.getNome(), stefamonEntity.getVida(),
                stefamonEntity.getAtaque(), stefamonEntity.getDefesa(), stefamonEntity.getInteligencia(),
                stefamonEntity.getPoder(), stefamonEntity.getVelocidade(), stefamonEntity.getUrlFoto());
    }

    public List<StefaMon> execute(List<StefamonEntity> listaStefamons) {
        List<StefaMon> stefaMons = new ArrayList<>();
        listaStefamons.forEach(stefaMon -> stefaMons.add((this.execute(stefaMon))));
        return Collections.unmodifiableList(stefaMons);
    }
}
