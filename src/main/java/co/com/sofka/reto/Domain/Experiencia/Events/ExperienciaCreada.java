package co.com.sofka.reto.Domain.Experiencia.Events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Experiencia.Experiencia;
import co.com.sofka.reto.Domain.Experiencia.Values.ExperienciaID;
import co.com.sofka.reto.Domain.Experiencia.Values.Precio;
import co.com.sofka.reto.Domain.Hotel.Values.HotelID;
import co.com.sofka.reto.Domain.Transporte.Values.TransporteID;

public class ExperienciaCreada extends DomainEvent {
    private final TransporteID transporteID;
    private final HotelID hotelID;
    private final Precio precio;

    public ExperienciaCreada( TransporteID transporteID, HotelID hotelID, Precio precio) {
        super("sofka.experiencia.ExperienciaCreada");
        this.transporteID=transporteID;
        this.hotelID=hotelID;
        this.precio=precio;
    }


    public TransporteID getTransporteID() {
        return transporteID;
    }

    public HotelID getHotelID() {
        return hotelID;
    }

    public Precio getPrecio() {
        return precio;
    }
}
