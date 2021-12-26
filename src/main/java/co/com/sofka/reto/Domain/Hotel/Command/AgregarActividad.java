package co.com.sofka.reto.Domain.Hotel.Command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Generic.Values.Descripcion;
import co.com.sofka.reto.Domain.Hotel.Values.ActividadID;
import co.com.sofka.reto.Domain.Hotel.Values.HotelID;

public class AgregarActividad extends Command {
    private final HotelID hotelID;
    private final ActividadID actividadID;
    private final Descripcion descripcion;
    public AgregarActividad(HotelID hotelID,ActividadID actividadID, Descripcion descripcion) {
        this.hotelID=hotelID;
        this.actividadID=actividadID;
        this.descripcion=descripcion;
    }

    public HotelID getHotelID() {
        return hotelID;
    }

    public ActividadID getActividadID() {
        return actividadID;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
