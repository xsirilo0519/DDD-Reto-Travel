package co.com.sofka.reto.Domain.Transporte.Events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Generic.Values.Telefono;
import co.com.sofka.reto.Domain.Transporte.Values.ResponsableID;

public class TelefonoResponsableActualizado extends DomainEvent {
    private final ResponsableID responsableID;
    private final Telefono telefono;
    public TelefonoResponsableActualizado(ResponsableID responsableID, Telefono telefono) {
        super("sofka.transporte.TelefonoResponsableActualizado");
        this.responsableID=responsableID;
        this.telefono=telefono;
    }

    public ResponsableID getResponsableID() {
        return responsableID;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
