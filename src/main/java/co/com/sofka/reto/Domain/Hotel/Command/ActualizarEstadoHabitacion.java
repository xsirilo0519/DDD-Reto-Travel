package co.com.sofka.reto.Domain.Hotel.Command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Hotel.Values.Estado;
import co.com.sofka.reto.Domain.Hotel.Values.HabitacionID;
import co.com.sofka.reto.Domain.Hotel.Values.HotelID;

public class ActualizarEstadoHabitacion extends Command {
    private final HotelID hotelID;
    private final HabitacionID habitacionID;
    private final Estado estado;
    public ActualizarEstadoHabitacion(HotelID hotelID,HabitacionID habitacionID, Estado estado) {
        this.hotelID=hotelID;
        this.habitacionID=habitacionID;
        this.estado=estado;
    }

    public HotelID getHotelID() {
        return hotelID;
    }

    public HabitacionID getHabitacionID() {
        return habitacionID;
    }

    public Estado getEstado() {
        return estado;
    }
}
