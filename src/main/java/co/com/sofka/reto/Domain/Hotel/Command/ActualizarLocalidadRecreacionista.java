package co.com.sofka.reto.Domain.Hotel.Command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Generic.Values.Localidad;
import co.com.sofka.reto.Domain.Hotel.Values.HotelID;
import co.com.sofka.reto.Domain.Hotel.Values.RecreacionistaID;

public class ActualizarLocalidadRecreacionista extends Command {
    private final HotelID hotelID;
    private final RecreacionistaID recreacionistaID;
    private final Localidad localidad;
    public ActualizarLocalidadRecreacionista(HotelID hotelID,RecreacionistaID recreacionistaID, Localidad localidad) {
        this.hotelID=hotelID;
        this.recreacionistaID=recreacionistaID;
        this.localidad=localidad;
    }

    public HotelID getHotelID() {
        return hotelID;
    }

    public RecreacionistaID getRecreacionistaID() {
        return recreacionistaID;
    }

    public Localidad getLocalidad() {
        return localidad;
    }
}
