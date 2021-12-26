package co.com.sofka.reto.Domain.Hotel.Command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Generic.Values.Email;
import co.com.sofka.reto.Domain.Generic.Values.Localidad;
import co.com.sofka.reto.Domain.Generic.Values.Nombre;
import co.com.sofka.reto.Domain.Generic.Values.Telefono;
import co.com.sofka.reto.Domain.Hotel.Values.HotelID;
import co.com.sofka.reto.Domain.Hotel.Values.RecreacionistaID;

public class AgregarRecreacionista extends Command {
    private final HotelID hotelID;
    private final RecreacionistaID recreacionistaID;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Email email;
    private final Localidad localidad;
    public AgregarRecreacionista(HotelID hotelID,RecreacionistaID recreacionistaID, Nombre nombre, Telefono telefono, Email email, Localidad localidad) {
        this.hotelID=hotelID;
        this.recreacionistaID=recreacionistaID;
        this.nombre=nombre;
        this.telefono=telefono;
        this.email=email;
        this.localidad=localidad;
    }

    public HotelID getHotelID() {
        return hotelID;
    }

    public RecreacionistaID getRecreacionistaID() {
        return recreacionistaID;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public Email getEmail() {
        return email;
    }

    public Localidad getLocalidad() {
        return localidad;
    }
}
