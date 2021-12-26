package co.com.sofka.reto.Domain.Transporte.Events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Generic.Values.Localidad;
import co.com.sofka.reto.Domain.Transporte.Values.ResponsableID;

public class LocalidadResponsableActualizada extends DomainEvent {
    private final ResponsableID responsableID;
    private final Localidad localidad;
    public LocalidadResponsableActualizada(ResponsableID responsableID, Localidad localidad) {
        super("sofka.transporte.LocalidadResponsableActualizada");
        this.responsableID=responsableID;
        this.localidad=localidad;
    }

    public ResponsableID getResponsableID() {
        return responsableID;
    }

    public Localidad getLocalidad() {
        return localidad;
    }
}
