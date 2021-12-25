package co.com.sofka.reto.Domain.Experiencia.Events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Experiencia.Values.Locacion;
import co.com.sofka.reto.Domain.Experiencia.Values.LugarID;
import co.com.sofka.reto.Domain.Experiencia.Values.Rango;

public class LugarAgregado extends DomainEvent {
    private final LugarID lugarID;
    private final Rango rango;
    private final Locacion locacion;
    public LugarAgregado(LugarID lugarID, Rango rango, Locacion locacion) {
        super("sofka.experiencia.LugarAgregado");
        this.locacion=locacion;
        this.rango=rango;
        this.lugarID=lugarID;
    }

    public LugarID getLugarID() {
        return lugarID;
    }

    public Rango getRango() {
        return rango;
    }

    public Locacion getLocacion() {
        return locacion;
    }
}
