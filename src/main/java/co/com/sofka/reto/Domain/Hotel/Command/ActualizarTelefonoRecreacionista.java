package co.com.sofka.reto.Domain.Hotel.Command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Generic.Values.Telefono;
import co.com.sofka.reto.Domain.Hotel.Values.HotelID;
import co.com.sofka.reto.Domain.Hotel.Values.RecreacionistaID;

public class ActualizarTelefonoRecreacionista extends Command {
    private final HotelID hotelID;
    private final RecreacionistaID recreacionistaID;
    private final Telefono telefono;
    public ActualizarTelefonoRecreacionista(HotelID hotelID,RecreacionistaID recreacionistaID, Telefono telefono) {
        this.hotelID=hotelID;
        this.recreacionistaID=recreacionistaID;
        this.telefono=telefono;
    }

    public HotelID getHotelID() {
        return hotelID;
    }

    public RecreacionistaID getRecreacionistaID() {
        return recreacionistaID;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
