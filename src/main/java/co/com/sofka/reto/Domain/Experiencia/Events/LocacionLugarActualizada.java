package co.com.sofka.reto.Domain.Experiencia.Events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Experiencia.Values.Locacion;
import co.com.sofka.reto.Domain.Experiencia.Values.LugarID;

public class LocacionLugarActualizada extends DomainEvent {
    private final LugarID lugarID;
    private final Locacion locacion;
    public LocacionLugarActualizada(LugarID lugarID, Locacion locacion) {
        super("sofka.experiencia.LocacionLugarActualizada");
        this.lugarID=lugarID;
        this.locacion=locacion;
    }

    public LugarID getLugarID() {
        return lugarID;
    }

    public Locacion getLocacion() {
        return locacion;
    }
}
