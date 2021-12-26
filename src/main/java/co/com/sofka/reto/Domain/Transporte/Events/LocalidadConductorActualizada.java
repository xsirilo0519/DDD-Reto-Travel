package co.com.sofka.reto.Domain.Transporte.Events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Generic.Values.Localidad;
import co.com.sofka.reto.Domain.Transporte.Values.ConductorID;

public class LocalidadConductorActualizada extends DomainEvent {
    private final ConductorID conductorID;
    private final Localidad localidad;
    public LocalidadConductorActualizada(ConductorID conductorID, Localidad localidad) {
        super("sofka.transporte.LocalidadConductorActualizada");
        this.localidad=localidad;
        this.conductorID=conductorID;
    }

    public ConductorID getConductorID() {
        return conductorID;
    }

    public Localidad getLocalidad() {
        return localidad;
    }
}
