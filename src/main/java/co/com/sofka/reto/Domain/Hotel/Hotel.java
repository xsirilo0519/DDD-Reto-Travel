package co.com.sofka.reto.Domain.Hotel;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.reto.Domain.Hotel.Values.HotelID;

import java.util.List;

public class Hotel extends AggregateEvent<HotelID> {
private Habitacion habitacion;
private Recreacionista recreacionista;
private List<Actividad> actividadList;


    public Hotel(HotelID hotelID) {
        super(hotelID);
    }
}
