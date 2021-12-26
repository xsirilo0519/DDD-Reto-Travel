package co.com.sofka.reto.Domain.Hotel.Events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Generic.Values.Nombre;

public class HotelCreado extends DomainEvent {
    private final Nombre nombre;

    public HotelCreado(Nombre nombre){
        super("sofka.hotel.HotelCreado");
        this.nombre=nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
