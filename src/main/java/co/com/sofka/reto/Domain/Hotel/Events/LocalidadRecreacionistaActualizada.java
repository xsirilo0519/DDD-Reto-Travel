package co.com.sofka.reto.Domain.Hotel.Events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Generic.Values.Localidad;
import co.com.sofka.reto.Domain.Hotel.Values.RecreacionistaID;

public class LocalidadRecreacionistaActualizada extends DomainEvent {

    private final RecreacionistaID recreacionistaID;
    private final Localidad localidad;
    public LocalidadRecreacionistaActualizada(RecreacionistaID recreacionistaID, Localidad localidad) {
        super("sofka.hotel.LocalidadRecreacionistaActualizada");
        this.recreacionistaID=recreacionistaID;
        this.localidad=localidad;
    }

    public RecreacionistaID getRecreacionistaID() {
        return recreacionistaID;
    }

    public Localidad getLocalidad() {
        return localidad;
    }
}
