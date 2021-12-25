package co.com.sofka.reto.Domain.Experiencia.Commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Experiencia.Values.ExperienciaID;
import co.com.sofka.reto.Domain.Experiencia.Values.Precio;
import co.com.sofka.reto.Domain.Hotel.Values.HotelID;
import co.com.sofka.reto.Domain.Transporte.Values.TransporteID;

public class CrearExperiencia extends Command {
    private final ExperienciaID experienciaID;
    private final TransporteID transporteID;
    private final HotelID hotelID;
    private final Precio precio;

    public CrearExperiencia(ExperienciaID experienciaID, TransporteID transporteID, HotelID hotelID, Precio precio) {
        this.experienciaID=experienciaID;
        this.transporteID=transporteID;
        this.hotelID=hotelID;
        this.precio=precio;
    }

    public ExperienciaID getExperienciaID() {
        return experienciaID;
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
