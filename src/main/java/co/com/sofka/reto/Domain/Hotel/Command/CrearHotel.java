package co.com.sofka.reto.Domain.Hotel.Command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Generic.Values.Nombre;
import co.com.sofka.reto.Domain.Hotel.Values.HotelID;

public class CrearHotel extends Command {
    private final HotelID hotelID;
    private final Nombre nombre;

    public CrearHotel(HotelID hotelID,Nombre nombre){
        this.hotelID=hotelID;
        this.nombre=nombre;
    }

    public HotelID getHotelID() {
        return hotelID;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
