package co.com.sofka.reto.Domain.Transporte.Events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Generic.Values.Telefono;
import co.com.sofka.reto.Domain.Transporte.Values.ConductorID;

public class TelefonoConductorActualizado extends DomainEvent {
    private final ConductorID conductorID;
    private final Telefono telefono;
    public TelefonoConductorActualizado(ConductorID conductorID, Telefono telefono) {
        super("sofka.transporte.TelefonoConductorActualizado");
        this.conductorID=conductorID;
        this.telefono=telefono;
    }

    public ConductorID getConductorID() {
        return conductorID;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
