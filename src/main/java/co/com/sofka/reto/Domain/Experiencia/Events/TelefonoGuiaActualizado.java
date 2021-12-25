package co.com.sofka.reto.Domain.Experiencia.Events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Experiencia.Values.GuiaID;
import co.com.sofka.reto.Domain.Generic.Values.Telefono;

public class TelefonoGuiaActualizado extends DomainEvent {
    private final GuiaID guiaID;
    private final Telefono telefono;
    public TelefonoGuiaActualizado(GuiaID guiaID, Telefono telefono) {
        super("sofka.experiencia.TelefonoGuiaActualizado");
        this.guiaID=guiaID;
        this.telefono=telefono;
    }

    public GuiaID getGuiaID() {
        return guiaID;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
