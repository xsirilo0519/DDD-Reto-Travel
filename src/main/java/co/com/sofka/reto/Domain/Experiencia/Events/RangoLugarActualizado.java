package co.com.sofka.reto.Domain.Experiencia.Events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Experiencia.Values.LugarID;
import co.com.sofka.reto.Domain.Experiencia.Values.Rango;

public class RangoLugarActualizado extends DomainEvent {
    private final LugarID lugarID;
    private final Rango rango;
    public RangoLugarActualizado(LugarID lugarID, Rango rango) {
        super("sofka.experiencia.RangoLugarActualizado");
        this.lugarID=lugarID;
        this.rango=rango;
    }

    public LugarID getLugarID() {
        return lugarID;
    }

    public Rango getRango() {
        return rango;
    }
}
