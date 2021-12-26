package co.com.sofka.reto.Domain.Hotel.Events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Generic.Values.Telefono;
import co.com.sofka.reto.Domain.Hotel.Values.RecreacionistaID;

public class TelefonoRecreacionistaActualizado extends DomainEvent {
    private final RecreacionistaID recreacionistaID;
    private final Telefono telefono;
    public TelefonoRecreacionistaActualizado(RecreacionistaID recreacionistaID, Telefono telefono) {
        super("sofka.hotel.TelefonoRecreacionistaActualizado");
        this.recreacionistaID=recreacionistaID;
        this.telefono=telefono;
    }

    public RecreacionistaID getRecreacionistaID() {
        return recreacionistaID;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
