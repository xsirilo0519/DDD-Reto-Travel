package co.com.sofka.reto.Domain.Hotel.Command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Generic.Values.Email;
import co.com.sofka.reto.Domain.Hotel.Values.HotelID;
import co.com.sofka.reto.Domain.Hotel.Values.RecreacionistaID;

public class ActualizarEmailRecreacionista extends Command {
    private final HotelID hotelID;
    private final RecreacionistaID recreacionistaID;
    private final Email email;
    public ActualizarEmailRecreacionista(HotelID hotelID,RecreacionistaID recreacionistaID, Email email) {
        this.hotelID=hotelID;
        this.recreacionistaID=recreacionistaID;
        this.email=email;
    }

    public HotelID getHotelID() {
        return hotelID;
    }

    public RecreacionistaID getRecreacionistaID() {
        return recreacionistaID;
    }

    public Email getEmail() {
        return email;
    }
}
