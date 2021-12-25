package co.com.sofka.reto.Domain.Experiencia.Events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Experiencia.Values.GuiaID;
import co.com.sofka.reto.Domain.Generic.Values.Localidad;

public class LocalidadGuiaActualizada extends DomainEvent {
    private final GuiaID guiaID;
    private final Localidad localidad;
    public LocalidadGuiaActualizada(GuiaID guiaID, Localidad localidad) {
        super("sofka.experiencia.LocalidadGuiaActualizada");
        this.guiaID=guiaID;
        this.localidad=localidad;
    }

    public GuiaID getGuiaID() {
        return guiaID;
    }

    public Localidad getLocalidad() {
        return localidad;
    }
}
