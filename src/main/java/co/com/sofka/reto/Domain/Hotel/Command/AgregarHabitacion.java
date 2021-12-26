package co.com.sofka.reto.Domain.Hotel.Command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Hotel.Values.Cant_Cama;
import co.com.sofka.reto.Domain.Hotel.Values.Estado;
import co.com.sofka.reto.Domain.Hotel.Values.HabitacionID;
import co.com.sofka.reto.Domain.Hotel.Values.HotelID;

public class AgregarHabitacion extends Command {
    private final HotelID hotelID;
    private final HabitacionID habitacionID;
    private final Estado estado;
    private final Cant_Cama cant_cama;
    public AgregarHabitacion(HotelID hotelID,HabitacionID habitacionID, Estado estado, Cant_Cama cant_cama) {
        this.hotelID=hotelID;
        this.habitacionID=habitacionID;
        this.estado=estado;
        this.cant_cama=cant_cama;
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

    public Cant_Cama getCant_cama() {
        return cant_cama;
    }
}
